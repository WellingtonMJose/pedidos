# Pedidos
Sistema que recebe pedidos de clientes e guarda em base de dados para que possa ser feito relatórios de pedidos de seus clientes.
## Planejamento
#### Montagem do ambiente de desenvolvimento. Estimativa: 1 hora.Concluido em: 1 hora 
- Baixar e instalação do Java v.21
- Configuração da IDE(IntellijIdea) e do banco(Postgres) de dados em local e Docker;
#### Desenvolvimento de Service, Controller, repositório e entidades. Estimativa: 6 horas. Concluido em 5 horas
- Desenvolvimento dos controllers;
- Desenvolvimento da camada de Entidades e repositório;
- Desenvolvimento da camada de Service
#### Consumo dos pedidos por mensageira. Estimativa de 2 horas. Concluido em 3 horas
- Desenvolvimento do rabbit no docker e configurado para o projeto consumir;
- Criação da exchange, Queue e feito um binding com routing-key;
#### Deploy da aplicação. Estimativa: 3 horas. Concluido em 4 horas
- Configuração de conta na nuvem no Render e CloudAmqp por permitir conta free;
- Verificado se Base de dados estava instanciada;
- Deploy da aplicação;
#### Documentação e teste manual da aplicação. Estimativa de 2 horas. Concluida em 2 horas
- Analise e escrita do escopo;
- Validações das funcionalidades;
- Gerações de evidências;

#### Tecnologias Utilizadas

- Linguagem: Java 21
- IDE: IntellijIdea
- Framework: Spring Boot
- Banco de dados: PostgreSQL
- Mensageria: RabbitMQ
- Postman
- Swagger Link da aplicação: [Swagger](https://pedidos-0hqf.onrender.com/swagger-ui/index.html)

<img src="../pedidos/asset/java_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/docker.png" width="40px" height="30px">
<img src="../pedidos/asset/github_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/postgres_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/rabbit_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/cloud_amqp_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/render_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/swagger_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/postman_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/dbeaver_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/intellijidea_logo.png" width="40px" height="30px">
<img src="../pedidos/asset/spring_logo.png" width="40px" height="30px">

## Diagrama de arquitetura

<img src="../pedidos/asset/diagrama_arquitetura.png" width="500px">

## Modelagem de dados
Por se tratar de uma aplicação simples foi criado apenas 3 tabelas <br>
<img src="../pedidos/asset/diagrama_entidade.png" width="500px">

##  Diagrama de implantação
<img src="../pedidos/asset/diagrama_arquiteturan.png" width="500px" >

## Diagrama de infra
<img src="../pedidos/asset/diagrama_infra.png" width="500px" ><br>
Descrição do Diagrama de Infraestrutura<br>
A aplicação "Pedidos" está hospedada na Render na região de Oregon (US West).<br>
A aplicação possui recursos de 0.1 CPU e 512 MB de memória.<br>
A aplicação está registrada no repositório GitHub. https://github.com/WellingtonMJose/pedidos<br>
A URL da aplicação é https://pedidos-0hqf.onrender.com.<br>

## Evidência de testes
Imagem da exchange criada, já com o binding na Queue <br>
<img src="../pedidos/asset/exchange_rabbit.png" width="500px"><br>

Imagem do envio de um pedido<br>
<img src="../pedidos/asset/request_rabbit.png" width="500px">

Imagem dos dados salvos na tabela de item_pedido<br>
<img src="../pedidos/asset/itens_pedido_database.png" width="500px"><br>

Imagem da busca do pedido via id<br>
<img src="../pedidos/asset/busca_id_pedido.png" width="500px">

Imagem da busca de todos os pedidos do cliente via id<br>
<img src="../pedidos/asset/busca_lista_todos_pedido_cliente.png" width="500px">

Imagem da busca de quantidade de pedidos do cliente via id<br>
<img src="../pedidos/asset/busca_qtd_pedidos_cliente.png" width="500px">

Imagem da busca de valor total do pedido do cliente via id<br>
<img src="../pedidos/asset/busca_qtd_pedidos_cliente.png" width="500px">

A aplicação adota uma arquitetura monolítica, centralizando toda a lógica de negócio em um único aplicativo.<br>
Essa escolha foi feita devido à simplicidade do projeto e ao baixo volume de transações esperado.<br>


<img src="../pedidos/asset/diagrama.png" width="500px" height="300px">


**API REST**: <br>
Expor a funcionalidade da aplicação através de uma API REST.<br>
Serviço de negócios: Contém a lógica de negócio da aplicação, incluindo o processamento de pedidos e a geração de relatórios.<br>
Banco de dados: Armazena as informações dos pedidos.<br>
**Event-Driven**: <br>
Mensageria: Utilizado para comunicação assíncrona entre os componentes.

### Obs:
Foi incluido um endpoint para auxiliar os testes, é um serviço com o metodo POST para salva o cliente trazendo mais facilidades nos testes,
não estava no escopo do projeto mas foi necessário pela praticidade.






