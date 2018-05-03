# Sistema para gerencimaneto de Test Drive realizado em revenda de automóveis

# Como Inicializar a aplicação localmente 

Necessário possuir o XAMPP instalado.
## Iniciar o Apache e MYsql

No XAMPP o usuário deve iniciar o serviço do Apache e Mysql

## Como instalar e rodar a aplicação

 - Baixar as dependências utilziando o MAVEN  
 - Clicar com o botão direito no projeto -> Run As Server -> TomCat v8.0.

# URI's

baseURI = http://localhost:8080/Concessionaria/ws/

## Clientes

### GET - Listar todos os Clientes
         URI: /clientes/listarClientes
         
### GET - Listar Clientes por ID
         URI: clientes/getCliente/{id}
         
### [POST] - Cadastrar Clientes
         URI: /clientes/cadastrarCliente
         
       {
            "nome": "Guilherme",
            "cpf": "12213221312",
            "cnh": "039126675",
            "telefone": "991521321"
        }

### [PUT] - Alterar Clientes
	     URI: /clientes/alterarCliente
	 
	    {
		   	"id": 1,
	        "nome": "Bruna",
	        "cpf": "995756563",
	        "cnh": "12322221",
	        "telefone": "991521321"
        }


### [DELETE] - Deletar cliente por ID
		URI: /clientes/excluirCliente/{id}                 

