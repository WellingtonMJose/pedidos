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

- Linguagem: Java 21 ![image](https://github.com/user-attachments/assets/eb457d1f-b8e9-44fe-9e43-b1163d0afa74)
- IDE: IntellijIdea
- Framework: Spring Boot
- Banco de dados: PostgreSQL
- Mensageria: RabbitMQ
- Swagger Link da aplicação: [Swagger](https://pedidos-0hqf.onrender.com/swagger-ui/index.html)

 
  ![image](https://github.com/user-attachments/assets/62018720-bf40-4aea-8deb-b589763fdffc)
  ![image](https://github.com/user-attachments/assets/6648ec17-cca3-47fd-ba42-a3639076862c)
 ![image](https://github.com/user-attachments/assets/312c7357-c5a0-479f-829b-271768e91092)
 ![image](https://github.com/user-attachments/assets/4093d484-a277-4e60-9c80-e863b42c6c43)
 ![image](https://github.com/user-attachments/assets/8ea44f95-963e-4fca-86cc-3d9cd990b503)
 ![image](https://github.com/user-attachments/assets/b7fe7098-73f1-4093-becf-2d2bacaee48c)
  ![image](https://github.com/user-attachments/assets/a9a1a220-f030-4b9e-ac16-6a3605b3bff2)
  
 ![image](https://github.com/user-attachments/assets/19a9a748-58fa-4865-8dc2-8eb30589cb3a)
 ![desafio - public](https://github.com/user-attachments/assets/5347ef06-2f99-45ed-aa87-f738de7b559b)
 ![image](https://github.com/user-attachments/assets/4f371711-e7e0-4cba-9a2b-e4a5967b586f)
 ![image](https://github.com/user-attachments/assets/75c21aa6-af35-4a35-8692-8ef3a7338541)

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














