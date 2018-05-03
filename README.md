# Sistema para gerencimaneto de Test Drive realizado em revenda de automóveis

# Como Inicializar a aplicação localmente 

Necessário possuir o XAMPP instalado.
## Iniciar o Apache e MYsql

No XAMPP o usuário deve iniciar o serviço do Apache e Mysql

## Como instalar e rodar a aplicação

 - Baixar as dependências utilziando o MAVEN  
 - Clicar com o botão direito no projeto -> Run As Server -> TomCat v8.0.

# URI's

baseURI = http://localhost:8080/Concessionaria/ws

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

## Funcionarios

### GET - Listar todos os Funcionarios
         URI: /funcionarios/listarFuncionarios

### GET - Listar Funcionarios por ID
         URI: funcionarios/getFuncionario/{id}
		 
### [POST] - Cadastrar Clientes
         URI: /funcionarios/cadastrarFuncionario
         
       {
            "nome": "Guilherme",
            "setor": "Vendas"
        }	

### [PUT] - Alterar Funcionarios
	     URI: /funcionarios/alterarFuncionario
	 
	    {
		   	"id": 1,
	        "nome": "Bruna",
	        "setor": "pos venda"
        }	

### [DELETE] - Deletar funcionarios por ID
		URI: /funcionarios/excluirFuncionario/{id} 	

## Automoveis

### GET - Listar todos os Automoveis
         URI: /automoveis/listarAutomoveis
         
### GET - Listar Automoveis por ID
         URI: /automoveis/getAutomovel/{id}
         
### [POST] - Cadastrar Automoveis
         URI: /automoveis/cadastrarAutomovel
         
       {
            "modelo": "Civic",
            "cor": "Preta",
            "placa": "IPI8993"
        }

### [PUT] - Alterar Automoveis
	     URI: /automoveis/alterarAutomovel
	 
	    {
		   	"id": 1,
	        "modelo": "CRV",
	        "cor": "branca",
	        "placa": "iqm7643"
        }


### [DELETE] - Deletar automoveis por ID
		URI: /automoveis/excluirAutomovel/{id}  		