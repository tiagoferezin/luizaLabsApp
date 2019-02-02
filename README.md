# luizalabs WS

Web Service Restful desafio luizalabs

# Setup Inicial

Banco de Dados usado Postgre
 - Classe de configuracao do Banco de dados ("luizalabsWS.config.ConfiguracaoDB.java")
 - na linha 36 a 37 setar o driver do DB;
 - na linha 38 configurar o usuário do DB;
 - na linha 39 configurar o password do DB;
 
- Salvar o arquivo na pasta do Tomcat por exemplo `C:\Program Files\Apache Software Foundation\Tomcat 7.0\wtpwebapps\luizalabsWS\WEB-INF\classes\funcionarios.txt`
PS: Usamos Tomcat como referência, para rodar interno. Se postar no servidor, basta apenas alterar o caminho na linha 54 da classe `luizalabsWS.model.entity.factory.ArquivoFactory.java`
 
- Rodar o WS - (http://localhost:8080/luizalabsWS/app/funcionario/buscarFuncionarios/)
Que ira carregar todos os funcionarios, lendo o arquivo funcionarios.txt e popular o DB.

# Doc API 

- Docs disponíveis no link - https://app.swaggerhub.com/apis/tiagoferezin/luizalabsWS/0.1

# Front
- http://localhost:8080/luizalabsWS/app/home/index
 
# Metodos GET

- Retorno do funcionario pelo CPF - (http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPeloCPF/cpf)
cpf -> numero do CPF do funcionario (apenas números)

- Retorno do funcionario pelo nome - (http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPeloNome/nomeDoFuncionario)
nomeDoFuncionario -> nome do funcionario (nome-completo)
  - Exemplo: `http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPeloNome/Tiago-Ferezin`

- Retorno do funcionario pelo cargo - (http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPeloCargo/cargo)
cargo -> cargo do funcionario
  - Exemplo: `http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPeloCargo/Dev-Java`

 - Retorno do funcionario pelo data de cadastro - (http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPelaDataCadastro/dataCad)
dataCad -> informar a data de cadastro do funcionario (Formato - dd-MM-aaaa)
   - Exemplo: `http://localhost:8080/luizalabsWS/app/funcionario/funcionarioPelaDataCadastro/18-02-2017`

- Retorno de quantidade de funcionarios por estado de nascimento - (http://localhost:8080/luizalabsWS/app/funcionario/quantidadeFuncionariosPorUfNascimento/) - retorna o UF e a quantidade de funcionarios nascidos naquela UF

- Retorno do funcionario pela faixa salarial - (http://localhost:8080/luizalabsWS/app/funcionario/funcionariosPorFaixaSalarial/{salarioBase}-{salarioTopo})
salarioBase ->  informe o salario base para pesquisa
salarioTopo ->  informe o salario topo para pesquisa
  - Exemplo: `http://localhost:8080/luizalabsWS/app/funcionario/funcionariosPorFaixaSalarial/3000-7500 `

- Retorno do funcionario pelo status - (http://localhost:8080/luizalabsWS/app/funcionario/funcionariosPorStatus/{status})
status -> informar o status do funcionario (ATIVO/INATIVO)

# Metodo POST (Adicionar ou Atualizar)

- Serviço para incluir um novo funcionario (caso o funcionario ja exista, ira atualizar) - (http://localhost:8080/luizalabsWS/app/funcionario/adicionarFuncionario/)
passar o parametro body o json conforme exemplo:
`{
    "dataCad": "19/04/2017",
    "cargo": "AC Sr",
    "cpf": "59984408701",
    "nome": "Aaron Aaby",
    "ufNasc": "RO",
    "salario": "5312.70",
    "status": "ATIVO"
}`

# Metodo Delete (Delecao)

- Servico para excluir funcionario pelo numero do CPF - (http://localhost:8080/luizalabsWS/app/funcionario/deleteFuncionarioCPF/cpf)
cpf -> informar numero do CPF do funcionario (apenas numeros)