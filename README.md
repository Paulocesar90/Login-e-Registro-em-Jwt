# teste do carteiro

Repo para demonstração  de como usar scripts de teste de API do carteiro. A própria API foi reduzida à sua funcionalidade mais básica para os testes. Todos os scripts estão no nível raiz do projeto. .

### Adicionar um novo usuario

O corpo deve ser JSON. Token de portador de autorização necessário nos cabeçalhos. Adiciona um novo usuario para o usuário atual. O ID do usuário vem do token. Amostra:

```json
{
    "name":"juliana",
    "cpf":"32136665467",
    "office":"desenvolvedora",
    "phone":"31988777544",
    "address":"rua almeida 1344, sete lagoas MG",
    "company":"CaféComJava",
    "email":"julianacafecomjava@gmail.com",
    "password":"123456"
}
```


### Faça login e receba um token

**POST** `http://localhost:8080/login`

O corpo da **solicitação** deve ser JSON. Amostra:

```json
{
   "name": "paulo",
  "password":"123456"
}
```

A solicitação válida retornará uma string JSON **resposta** como esta amostra:

```json
{
  
     "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5hIiwiZXhwIjoxNjgwNDU5MTgxfQ.NuUDE0KzN6tWoah8ug67v1r2RC1nni_ZEWVLMvqEy8l5xqzkua_O7dQbvJFaCY924B2ZtpNSUX-vidBl1glvjw"
   }




```

### Obter lista usuarios

Nenhum corpo necessário. Token de portador de autorização necessário nos cabeçalhos. Retornará a lista de todos os usuarios para o usuário atual com base no id no token assinado.Teremos que passar Headers para validar o token gerado

![Spring](https://github.com/Paulocesar90/Login-e-Registro-em-Jwt/blob/master/imagens/Authorization.png)

**GET** `http://localhost:8080/api/user/listAll`


Exemplo de **Resposta**:

```json
{
   "dados":[
    {
        "id": 1,
        "name": "paulo",
        "office": "desenvolvedor",
        "phone": "31988775544",
        "address": "rua almeida 1344, sete lagoas MG",
        "company": "CaféComJava",
        "email": "cafecomjava@gmail.com",
        "password": "$2a$10$iR.nRpWo0GupmEPQOZRdPuzfKfoarPqZP6NlalqVGa.e35so.fo8u",
        "cpf": "32134565467"
    },
    {
        "id": 2,
        "name": "juliana",
        "office": "desenvolvedora",
        "phone": "31988777544",
        "address": "rua almeida 1344, sete lagoas MG",
        "company": "CaféComJava",
        "email": "julianacafecomjava@gmail.com",
        "password": "$2a$10$CSb9ULWOiOh1nvMO2aAspOF3KDS2rbRGLCCPEXdI9WPrQ3XTcvYim",
        "cpf": "32136665467"
    }
]
   
}
```
