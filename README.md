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

## Arquitetura da Aplicação

A aplicação adota uma arquitetura monolítica, centralizando toda a lógica de negócio em um único aplicativo. Essa escolha foi feita devido à simplicidade do projeto e ao baixo volume de transações esperado.

#### Diagrama de Componentes


O diagrama acima mostra os principais componentes da aplicação:

**API REST**: Expor a funcionalidade da aplicação através de uma API REST.
Serviço de negócios: Contém a lógica de negócio da aplicação, incluindo o processamento de pedidos e a geração de relatórios.
Banco de dados: Armazena as informações dos pedidos.
Mensageria: Utilizado para comunicação assíncrona entre os componentes.
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


 Json de exemplo
 {
    "codigoPedido": 25,
    "codigoCliente": 1,
    "itens": [
        {
            "produto": "Mesa",
            "quantidade": 2,
            "preco": 799.99
        },
        {
            "produto": "Cadeira",
            "quantidade": 4,
            "preco": 999.99
        },
        {
            "produto": "Armario de cozinha",
            "quantidade": 1,
            "preco": 1449.00
        }
    ]
}














