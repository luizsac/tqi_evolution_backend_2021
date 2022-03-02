<h1 align="center">TQI Evolution Backend 2021</h1>

<p align="center">REST API para solicitação de empréstimos</p>

- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Como usar](#como-usar)
    - [Pré-requisitos](#pr-requisitos)
    - [Como executar](#como-executar)

## Sobre


## Tecnologias
- [Java](https://openjdk.java.net/)
- [Spring Boot](https://spring.io/) (Web, Data JPA, Security)
- [Gradle](https://gradle.org/)
- [Java JWT](https://github.com/jwtk/jjwt)
- [Project Lombok](https://projectlombok.org/)

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

### Rotas

#### Criar usuário
```
POST /account/create
```
```
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
```
  
#### Fazer login
```
POST /login
```
```
{
    "username": "snow@nightswatch.com",
    "password": "iknowsomething"
}
```
  
> Para acessar as próximas rotas, é necessário inserir o token recebido no processo de login à variável "Authorization" do Header da Requisição
  
#### Criar solicitação de empréstimo
```
POST /user/request-loan
```
```
{
    "amount": "3342.98",
    "firstInstallmentDt": "2022-02-02",
    "numberOfInstallments": "34"
}
```
  
#### Listar solicitações de empréstimo
```
GET /user/loan-requests
```
  
#### Detalhar solicitação de empréstimo
```
GET /user/loan-request/{id}
```