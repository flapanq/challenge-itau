Foi adotado o Padrão de Arquitetura Hexagonal
Os pontos fortes desta arquitetura são:
- Código organizado em camadas.
- As camadas são autocontidas.
- As camadas se comunicam com as outras por portas e adptadores.
- O lógica da aplicação fica isolada sem dependencias externas.
- Facilita a troca de dependencias externas trocando os adaptadores.
- O componentes são fracamente acoplados.


- Foi identicado a necessidade do design pattern Stratey que define uma família de algoritmos, encapsular cada um, e fazê-los intercambiáveis, ele permite que algoritmos variem independentemente entre clientes que os utilizam. Assim evitando a nessidade de
if encadeados nas validações.
Ex:
OfferActiveStrategy.java
OfferAssistanceStrategy.java
OfferCoverageStrategy.java
OfferCoverageTotalStrategy.java
OfferMinMaxStrategy.java
OfferValidateStrategy.java


O que não tive tempo para concluir:
O endpoint para consulta de cotações.
Observabilidade (métricas, traces e logs).
 

 


 









 



 


 


 

  



 

 








