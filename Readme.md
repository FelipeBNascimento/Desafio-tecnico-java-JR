# Desafio-tecnico-java-JR

## Desafio tecnico java Junior:
Uma aplicação simples em Java para cadastro de abastecimento em um posto de combustível,
usando um banco de dados e ApiRest

## Pré-requisitos

### Ferramentas
 * Java 17
 * Gradle
 * SpringBoot 3.5.7
 * Postman
 * Banco de daods SQL Postgre

### Dependências
* implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
* implementation 'org.springframework.boot:spring-boot-starter-web'
* compileOnly 'org.projectlombok:lombok'
* runtimeOnly 'org.postgresql:postgresql'
* annotationProcessor 'org.projectlombok:lombok'
* testImplementation 'org.springframework.boot:spring-boot-starter-test'
* testRuntimeOnly 'org.junit.platform:junit-platform-launcher'


## Como executar o projeto através do Postman

### Requisições de um tipo de combustivel

POST localhost:8080/tipocombustivel
* No body
  *     { 
           "name" : "Gasolina",
           "preco_litro" : 5.25
         }

GET localhost:8080/tipocombustivel
  
DELETE localhost:8080/tipocombustivel?id=1
* Params Key - id, Value 1

PUT localhost:8080/tipocombustivel?id=1
* Params Key - id, Value 1
* No body
*     { 
          "name": "Etanol",
          "preco_litro": 4.20
      }

### Requisições de Bomba Combustível

POST localhost:8080/bombacombustivel
* No body
*     { 
          "name": "Bomba 02",
          "tipoCombustivel": {
              "id": 1
            }
        }

GET localhost:8080/bombacombustivel?id=1
* Params Key - id, Value 1

DELETE localhost:8080/bombacombustivel?id=1
* Params Key - id, Value 1

PUT localhost:8080/bombacombustivel?id=1
* Params Key - id, Value 1
  * No body
*     { 
          "name": "Bomba 04",
          "tipoCombustivel": {
              "id": 1
            }
        }

### Requisições de Abastecimento 

POST localhost:8080/abastecimentocombustivel?idBomba=4&litros=50
* Params Key - idBomba, Value 4
* Params Key - litros, Value 50

GET localhost:8080/abastecimentocombustivel?id=1
* Params Key - id, Value 1