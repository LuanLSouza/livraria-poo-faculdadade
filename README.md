# Gerenciador de Livraria

Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos III (POO III). O objetivo é implementar um sistema de gerenciamento de livraria, aplicando conceitos avançados de orientação a objetos, padrões de projeto e boas práticas de desenvolvimento.

## Funcionalidades

- Cadastro, edição e remoção de livros
- Gerenciamento de clientes
- Controle de vendas
- Consulta de estoque

## Estrutura do Projeto

O projeto está organizado seguindo o padrão MVC (Model-View-Controller), separando as responsabilidades em diferentes camadas:

### Model

Contém as classes que representam as entidades do sistema, como `Livro`, `Cliente` e `Venda`. Essas classes encapsulam os dados e regras de negócio.

### DAO (Data Access Object)

A camada DAO é responsável pela comunicação com o banco de dados. Cada entidade possui um DAO correspondente, como `LivroDAO`, que realiza operações de CRUD (Create, Read, Update, Delete) utilizando SQL.

### View

A camada View é responsável pela interface com o usuário. Pode ser implementada via terminal (console) ou interface gráfica (Swing/JavaFX), exibindo informações e recebendo comandos do usuário.

### Controller

Os controllers fazem a mediação entre a View e o Model/DAO, processando as ações do usuário, validando dados e coordenando as operações do sistema.

## Conceitos Aplicados

- **Encapsulamento**: Proteção dos dados das entidades.
- **Herança e Polimorfismo**: Utilizados para generalizar comportamentos comuns entre classes.
- **Padrão DAO**: Separação da lógica de acesso a dados.
- **Padrão MVC**: Organização do código em camadas.
- **Tratamento de Exceções**: Garantia de robustez nas operações.

## Como Executar

1. Certifique-se de ter o Java instalado.
2. Compile o projeto usando o Ant (`build.xml`).
3. Execute a aplicação conforme instruções do seu ambiente.

## Créditos

Desenvolvido por [Seu Nome] para a disciplina de POO III.
