  # Exchange App Made With Spring Boot

<h5>REQUIREMENTS<br>
Java 11+<br>
Mysql<br>
Maven<br>


<h5>RUN<br>
mvn clean install<br>
java -jar ...\target\cambio-0.0.1-SNAPSHOT.jar<br>

<br>
<h5>API Endpoints
<br>
  
| Método  |  Uri  | Body |
| ------- | ----- | ---- |
|  GET | /moeda  |  - |
|  GET |  /moeda/{id}  | - |
|  GET |  /moeda/{simbolo}  | - |
|  POST | /moeda  | "nome", "simbolo"|
|  DELETE | /moeda/{id}  | - |
|  GET | /cotacao/{símbolo}  | - |
|  POST  |  /cotacao/{símbolo}/{ano}/{mes}/{dia}  | "valor"

