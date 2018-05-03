# Sistema para gerencimaneto de Test Drive realizado em revenda de automóveis
Aluno: Guilherme Leindecker
Senac/RS

### Como Inicializar a aplicação localmente  

### Iniciar o Apache / MYsql
```
Iniciar o serviço do apache / Mysql pelo XAMPP
```
### Como instalar e rodar a aplicação
```
-> Baixar as dependências utilziando o MAVEN
 -> Clicar com o botão direito no projeto -> Run As Server -> TomCat v8.0
```
### URI's
```
Clientes
```
[GET] - Listar todos os clientes
http://localhost:8080/Concessionaria/ws/clientes/listarClientes
```
[GET] - Listar Clientes por ID
http://localhost:8080/Concessionaria/ws/clientes/getCliente/{id}
```
[POST] - Cadastrar Clientes
http://localhost:8080/Concessionaria/ws/clientes/cadastrarCliente
JSON data:
   {
        "nome": "Guilherme",
        "cpf": "12213221312",
        "cnh": "039126675",
        "telefone": "991521321"
    }
```
[PUT] - Alterar cliente
http://localhost:8080/Concessionaria/ws/clientes/alterarCliente
JSON data:
   {
   		"id": 1,
        "nome": "Bruna",
        "cpf": "995756563",
        "cnh": "12322221",
        "telefone": "991521321"
    }
```
[DELETE] - Excluir cliente por ID
http://localhost:8080/Concessionaria/ws/clientes/excluirCliente/{id}


