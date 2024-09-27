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
- Postman, Swagger
- Docker, Render, CloudAmqp
- GitHub para versionamento de código

![image](https://github.com/user-attachments/assets/17793dbc-6488-4979-8754-6660074f5dfe)
![image](https://github.com/user-attachments/assets/8c3e4ef6-61f6-4858-8faa-a5a5ee879dae)
![image](https://github.com/user-attachments/assets/00b526de-ec5c-415e-9cf0-b2a4439e1283)
![image](https://github.com/user-attachments/assets/253432f0-86ee-46b0-b79a-43c3d4d94471)
![image](https://github.com/user-attachments/assets/8c44b5a6-1e85-48e0-9069-fbee5c38285a)
![image](https://github.com/user-attachments/assets/2989b1a3-6cd1-4d64-90b3-537cad6f84c0)
![image](https://github.com/user-attachments/assets/886b9ca6-ae34-4ced-b33a-20880443e10d)
![image](https://github.com/user-attachments/assets/08f5d390-d0e6-413e-a30e-cc123c2c0c0b)
![image](https://github.com/user-attachments/assets/4657e531-7bac-4946-ad31-6ab083d6889f)
![image](https://github.com/user-attachments/assets/744ab41d-2c33-4704-aff4-06712604a59f)
![image](https://github.com/user-attachments/assets/317c34c4-e53a-4333-bd91-088d8c23ad8c)
![image](https://github.com/user-attachments/assets/2c9de72a-732f-47da-b6d8-23bed768fdd0)

<br>

## Diagrama de arquitetura
![image](https://github.com/user-attachments/assets/6c76041e-8bb3-4cc5-b630-ee3509ceb782)

## Modelagem de dados
Por se tratar de uma aplicação simples foi criado apenas 3 tabelas <br>
![image](https://github.com/user-attachments/assets/19267a13-d72e-4154-bd57-946098d740de)

##  Diagrama de implantação
![image](https://github.com/user-attachments/assets/4b3cd52b-957e-4d29-9d9e-e1e6b178c82d)

## Diagrama de infra
![image](https://github.com/user-attachments/assets/570f461d-eb0d-4d7a-9c4d-367ee0f1c5b9)

Descrição do Diagrama de Infraestrutura<br>
A aplicação "Pedidos" está hospedada na Render na região de Oregon (US West).<br>
A aplicação possui recursos de 0.1 CPU e 512 MB de memória.<br>
A aplicação está registrada no repositório GitHub. https://github.com/WellingtonMJose/pedidos<br>
A URL da aplicação é https://pedidos-0hqf.onrender.com.<br>

## Evidência de testes
Imagem da exchange criada, já com o binding na Queue <br>
![image](https://github.com/user-attachments/assets/0a73fba7-8701-457d-b298-cd0fb89be4f2)


Imagem do envio de um pedido<br>
![image](https://github.com/user-attachments/assets/2d73dbd2-6fba-400a-8972-2464c3461cf5)


Imagem dos dados salvos na tabela de item_pedido<br>
![image](https://github.com/user-attachments/assets/e785c761-9883-47cb-96aa-99be5fdd2cc4)


Imagem da busca do pedido via id<br>
![image](https://github.com/user-attachments/assets/3f6b0328-83e8-49a1-89cc-940714b0d4a5)

Imagem da busca de todos os pedidos do cliente via id<br>
![image](https://github.com/user-attachments/assets/57ad6d38-55ff-42b7-bc9c-265a84a0da45)

Imagem da busca de quantidade de pedidos do cliente via id<br>
![image](https://github.com/user-attachments/assets/490e9904-ca8d-42ea-98b2-8cb3928b2cb7)

Imagem da busca de valor total do pedido do cliente via id<br>
![image](https://github.com/user-attachments/assets/e6b25dc3-eec8-428f-b7f0-6b67a9be0f37)

A aplicação adota uma arquitetura monolítica, centralizando toda a lógica de negócio em um único aplicativo.<br>
Essa escolha foi feita devido à simplicidade do projeto e ao baixo volume de transações esperado.<br>

## Links para acessar:
- Swagger Link da aplicação: [Swagger](https://pedidos-0hqf.onrender.com/swagger-ui/index.html)
- CloudAmqp [CloudAmqp exchange](https://chimpanzee.rmq.cloudamqp.com/#/exchanges/rlchzaid/exchange.btg)
- Imagem Docker [Docker image Pedidos](https://api.render.com/deploy/srv-crqlgdrgbbvc73frc2ng?key=T3i0IOSkVF8)


![image](https://github.com/user-attachments/assets/a702a5d1-d7eb-4a63-afc3-7b2e37208c68)
<br>
**API REST**: <br>
Expor a funcionalidade da aplicação através de uma API REST.<br>
Serviço de negócios: Contém a lógica de negócio da aplicação, incluindo o processamento de pedidos e a geração de relatórios.<br>
Banco de dados: Armazena as informações dos pedidos.<br>
**Event-Driven**: <br>
Mensageria: Utilizado para comunicação assíncrona entre os componentes.

### Obs:
Foi incluido um endpoint para auxiliar os testes, é um serviço com o metodo POST para salva o cliente trazendo mais facilidades nos testes,
não estava no escopo do projeto mas foi necessário pela praticidade.






