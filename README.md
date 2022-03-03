<h1 align="center">TQI Evolution Backend 2021</h1>

<p align="center">REST API para solicitação de empréstimos</p>

- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Como usar](#como-usar)
    - [Pré-requisitos](#pré-requisitos)  <!-- confia! -->
    - [Como executar](#como-executar)
- [Rotas](#rotas)
  - [Criar usuário](#criar-usuário)
  - [Fazer login](#fazer-login)
  - [Criar solicitação de empréstimo](#criar-solicitação-de-empréstimo)
  - [Listar solicitações de empréstimo](#listar-solicitações-de-empréstimo)
  - [Detalhar solicitação de empréstimo](#detalhar-solicitação-de-empréstimo)
- [Licença](#licença)
- [Autor](#autor)

## Sobre
API desenvolvida para o desafio TQI Evolution Backend 2021. É uma aplicação Spring Boot que utiliza Spring Security
com JWT para autenticação de usuários, Project Lombok para geração de código boilerplate e tem o MySQL como banco de
dados relacional. 

## Tecnologias
- [Java](https://openjdk.java.net/)
- [Spring Boot](https://spring.io/) (Web, Data JPA, Security)
- [Gradle](https://gradle.org/)
- [Java JWT](https://github.com/jwtk/jjwt)
- [Project Lombok](https://projectlombok.org/)
- [MySQL](https://dev.mysql.com/downloads/)

## Como usar
### Pré-requisitos
- [Git](https://git-scm.com/downloads)
- [Java Runtime Environment](https://www.java.com/pt-BR/download/)
- [Docker](https://www.docker.com/)

### Como executar
Clone o repositório: `git clone https://github.com/luizsac/tqi_evolution_backend_2021.git`

Entre na pasta do projeto: `cd tqi_evolution_backend_2021`

Suba o container do banco de dados no docker: `docker run --name mysql_container -p 3306:3306 -e MYSQL_ROOT_PASSWORD=tqi_evo_pw -d mysql:latest`

Execute a aplicação: `.\gradlew bootRun` no Windows ou `./gradlew bootRun` no Linux/Mac

## Rotas

### Criar usuário
#### Request
`POST /account/create`

<pre>
{
    "name": "Jon Snow",
    "email": "snow@nightswatch.com",
    "cpf": "01234567890",
    "rg": "wt21123432",
    "address": "Winterfell, The North - Westeros",
    "income": "222134.12",
    "password": "iknowsomething",
    "roles": ["USER"]
}
</pre>

#### Response
    HTTP/1.1 201 Created
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 201 Created
    Content-Type: application/json

<pre>
{
    "user_id": 3,
    "name": "Jon Snow",
    "email": "snow@nightswatch.com",
    "cpf": "01234567890",
    "rg": "wt21123432",
    "address": "Winterfell, The North - Westeros",
    "income": 222134.12
}
</pre>
  
### Fazer login
#### Request
`POST /login`

<pre>
{
    "username": "snow@nightswatch.com",
    "password": "iknowsomething"
}
</pre>

#### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
{
    "name": "Jon Snow",
    "username": "snow@nightswatch.com"
}
</pre>

> Para acessar as próximas rotas, é necessário inserir o token recebido no processo de login à variável "Authorization" do Header da Requisição
  
### Criar solicitação de empréstimo
#### Request
`POST /user/request-loan`

<pre>
{
    "amount": "3342.98",
    "firstInstallmentDt": "2022-02-02",
    "numberOfInstallments": "34"
}
</pre>

#### Response
    HTTP/1.1 201 Created
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 201 Created
    Content-Type: application/json

<pre>
{
    "requestId": 10,
    "amount": 3342.98,
    "firstInstallmentDt": "2022-02-02",
    "numberOfInstallments": 34
}
</pre>
  
### Listar solicitações de empréstimo
#### Request
`GET /user/loan-requests`

### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
[
    {
        "requestId": 10,
        "amount": 3342.98,
        "firstInstallmentDt": "2022-02-02",
        "numberOfInstallments": 34
    }
]
</pre>
  
### Detalhar solicitação de empréstimo
#### Request
`GET /user/loan-request/{id}`

#### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
{
    "requestId": 3,
    "amount": 3342.98,
    "numberOfInstallments": 34,
    "firstInstallmentDt": "2022-02-02",
    "userEmail": "luiz@gmail.com",
    "userIncome": 222134.12
}
</pre>

## Licença
Essa API está sob a licença MIT. Veja o arquivo [LICENSE](https://github.com/luizsac/people-rest-api/blob/main/LICENSE) para mais informações.

## Autor
[![Linkedin Badge](https://img.shields.io/badge/Luiz_Henrique_Salgado_Andrade_Cardoso-0a66c2?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/luizsac/)](https://www.linkedin.com/in/luizsac/)
[![Linkedin Badge](https://img.shields.io/badge/luizhenriquesalgado@outlook.com.br-0073c6?style=flat-square&logo=Microsoft-Outlook&logoColor=white&link=mailto:luizhenriquesalgado@outlook.com.br)](mailto:luizhenriquesalgado@outlook.com.br)
