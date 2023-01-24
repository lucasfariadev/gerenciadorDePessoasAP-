<h2>API de gerenciamento de Pessoas</h2>

### CRUD
*	Criar uma pessoa
*	Editar uma pessoa
*	Consultar uma pessoa
*	Listar pessoas
*	Criar endereço para pessoa
*	Listar endereços da pessoa
*	Poder informar qual endereço é o principal da pessoa  


```
http://localhost:8080/pessoas
http://localhost:8080/enderecos
```

## Banco de dados: 
* H2 para
* http://localhost:8080/h2-console  
* Adicionar na URL o nome do banco desta forma : jdbc:h2:mem:testdb
* Nome do banco de dados: testdb



## Utilizando a API: 
    ### criando Pessoa:
        * POST - Create 
        ```
        http://localhost:8080/pessoa

```
```
        {
            "nome" : "Fulano de Tal",
            "nascimento" : "01/01/2001",
            "enderecos":[
                    {
                        "logradouro": "Rua de Teste 1",
                        "cep" : 123456,
                        "numero" : 89
                    },
                    {
                        "logradouro": "Rua de Teste 2",
                        "cep" : 7891011,
                        "numero" : 90
                    }
                ]
        }
```
        
        ### criando Endereco:
        * POST - Create 
        ```
        http://localhost:8080/enderecos
        ```
        
         ```
        {
            "logradouro": "Rua de Teste 1",
            "cep" : 123456,
            "numero" : 89
        }
        
        ```
        ### Outras operações podem ser realizadas 
        * GET
        * PUT
        * DELETE


