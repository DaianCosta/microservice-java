# Arquitetura micro serviç Spring Cloud Netflix

## Gateway
Centralizador das requisicoes dos servicos.
Essa camada sera responsável por fazer o Load balance, tornando os serviços escaláveis.

## Auth
Serviço responsável por prover segurança entre os serviços.

## Crud
Serviço responsável por prover as funcionalidades de crud de produto e publicador o produto criado na fila do rabbitmq, para que o serviço de pagamento possa consumir o produto de forma asyncrona.

## Pagamento
Serviço responsável por prover as funcionalidades de pagamento e consumo asyncro dos produtos cadastrados no serviço crud de produto.

## Rabbitmq
Service Broker, responsável por gerenciar as exchanges e queues

## Tecnologias:
Java 11\
Spring boot\
Spring security/JWT\
Spring HATEOAS\
Spring Data Jpa\
Lombok\
Mysql\
Eureka discovery Server/Client\
Spring cloud Gateway


![alt text](./arquitetura-sring.png)