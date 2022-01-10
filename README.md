## TQI Evolution Backend 2021
___
### Comando docker para subir o banco de dados
docker run --name mysql_container -p 3306:3306 -e MYSQL_ROOT_PASSWORD=tqi_evo_pw -d mysql:latest

### Rotas
___

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