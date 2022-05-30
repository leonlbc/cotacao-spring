package br.espm.cambio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import br.espm.cambio.Cotacao.CotacaoService;
import br.espm.cambio.Moeda.MoedaService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = CambioApplication.class)
@WebMvcTest
public class CambioResourceTest {

	@Autowired
	private MockMvc mockMvc;
    
    @MockBean
    private MoedaService moedaService;

    @MockBean
    private CotacaoService cotacaoService;

    @Test
    public void moedaListShouldReturnOk() throws Exception{
        mockMvc.perform(get("/moeda"))
            .andDo(print()).andExpect(status().isOk());
    }
}
