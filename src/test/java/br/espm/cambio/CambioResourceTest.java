package br.espm.cambio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import br.espm.cambio.Cotacao.CotacaoService;
import br.espm.cambio.Moeda.Moeda;
import br.espm.cambio.Moeda.MoedaService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@ContextConfiguration(classes = CambioApplication.class)
@WebMvcTest
public class CambioResourceTest {

	@Autowired
	private MockMvc mockMvc;
    
    @MockBean
    private MoedaService moedaService;

    @MockBean
    private CotacaoService cotacaoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void moedaListShouldReturn200() throws Exception{
        mockMvc.perform(get("/moeda"))
            .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void moedaGetBySimboloShouldReturn200() throws Exception{
        String simbolo = "BRL";
        mockMvc.perform(get(String.format("/moeda/%s", simbolo)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void moedaValidPostReturn200() throws Exception{
        Moeda moeda1 = new Moeda("Euro", "EUR");
        mockMvc.perform(post("/moeda")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(moeda1)))
            .andExpect(status().isOk());
    }

    @Test
    public void moedaInvalidPostReturn500() throws Exception{
        Moeda moeda1 = new Moeda(null, "EUR");
        mockMvc.perform(post("/moeda")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(moeda1)))
            .andExpect(status().isBadRequest());
    }
}
