
# <p align="center">API PharmaPDV</p>

## 💻 Sobre o projeto

API para gerenciar medicamentos, através de um sistema de gestão. 
A API REST proverá os serviços para a execução do sistema 
possibilitando manter o cadastro de Farmácias, Medicamentos e seus Estoques.


## 🚧 Funcionalidades

- [x] Criar Farmácia: Cria uma nova farmácia.
- [x] Consultar Farmácias: Retorna a lista de todas as farmácias.
- [x] Consultar Farmácia por CNPJ: Retorna informações sobre uma farmácia específica.
- [x] Criar Medicamento: Cria um novo medicamento.
- [x] Consultar Medicamentos: Retorna a lista de todos os medicamentos.
- [x] Consultar Medicamento por Número de Registro: Retorna informações sobre um medicamento específico.
- [x] Criar Estoque: Cria um novo item de estoque.
- [x] Consultar Estoque: Retorna a lista de todos os itens de estoque.
- [x] Consultar Estoque por CNPJ: Retorna a lista de itens de estoque para um CNPJ específico.
- [x] Atualizar Transferência de Estoque: Atualiza a transferência de estoque entre farmácias.
- [x] Excluir Estoque: Exclui um item de estoque.
- [x] Popular Dados Iniciais: Popula dados iniciais no sistema.

## 🛠️ Tecnologias
Para o desenvolvimento da aplicação, foram utilizadas às tecnologias e dependências abaixo:

| Nome            | Versão |
|:----------------|:-------|
| Java            | JDK 17 |
| Spring Boot     | 3.2.0  |
| Maven           |        |
| Spring Web      |        |
| Spring Data JPA |        |
| Validation      |        |
| Lombok          |        |
| ModelMapper     |        |
| PostgreSQL      |        |
| Swagger         |        |

## ⚠️ Pré-requisitos


Para executar essa aplicação, você precisará atender a alguns pré-requisitos. Aqui estão os principais:

1. Java Development Kit (JDK):

A aplicação está configurada para usar Java 17. Certifique-se de ter o JDK 17 ou uma versão posterior instalada em seu ambiente.

2. PostgreSQL:

A aplicação utiliza o PostgreSQL como banco de dados. Certifique-se de ter uma instância do PostgreSQL instalada e em execução. Você também precisará configurar as credenciais do banco de dados no arquivo de configuração da aplicação.

3. Maven:

Certifique-se de ter o Maven instalado. O Maven é usado para gerenciar as dependências e construir o projeto. Você pode baixar o Maven em Apache Maven.

4. Ambiente de Desenvolvimento Integrado (IDE):

Embora não seja um requisito estrito, é altamente recomendável usar uma IDE como IntelliJ IDEA, Eclipse ou Visual Studio Code para facilitar o desenvolvimento e a execução da aplicação.

5. Configuração do Banco de Dados:

Crie um banco de dados PostgreSQL `farmaciadb` e configure as propriedades de conexão no arquivo de configuração da aplicação.

6. Configuração do Projeto:

Certifique-se de que o arquivo pom.xml está configurado corretamente e que todas as dependências estão atualizadas.

## ⚙️ Configuração da aplicação em modo desenvolvimento

1. Clone o Repositório:
Clone o repositório do GitHub para o seu ambiente local usando o seguinte comando no terminal:

````git clone https://github.com/patriciagrocha/pharmaPDV-api.git````

2. Abra o Projeto na IDE:

Abra o projeto clonado em sua IDE favorita (como IntelliJ, Eclipse ou Visual Studio Code).

3. Configure o Banco de Dados:

Configure as propriedades do banco de dados no arquivo src/main/resources/application.properties ou src/main/resources/application.yml. 
Forneça as informações necessárias, como URL do banco de dados, nome do banco de dados, usuário e senha.
4. Build do Projeto: 

Execute o comando de build usando o Maven:

``./mvnw clean install``

5. Execute a Aplicação:

Após a conclusão do build, execute o aplicativo usando o seguinte comando:

``mvn spring-boot:run``

6. Acesse a Aplicação:

Abra um navegador da web e acesse http://localhost:8080 (ou a porta que você configurou). 

## 📄 Documentação da API

- Acesso através do swagger-ui:  http://localhost:8080/api/v1/swagger-ui/index.html


## 🦸 Autoria

<div style="display: flex; flex-direction: column;">
<h3>Patrícia Rocha</h3>
<a href="https://www.linkedin.com/in/patriciagrocha/" target="_blank">
<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="logo linkedin" style="width: 150px; height: 30px;">
</a>
</div>


### 📝 Licença

Este projeto está sob a licença [MIT](./LICENSE).