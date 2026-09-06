# Spring Web API

Uma API REST simples construída com Spring Boot para gerenciamento de usuários, desenvolvida como projeto de estudo/prática.

## Tecnologias

- **Java 25**
- **Spring Boot 4.1.1**
- **Gradle** (com wrapper)
- **JUnit 5** para testes

## Estrutura do Projeto

```
src/main/java/com/bento/springwebapi
├── SpringWebApiApplication.java   # Ponto de entrada da aplicação
├── controller
│   ├── WelcomeController.java     # Endpoint de boas-vindas
│   └── UsuarioController.java     # Endpoints CRUD de usuários
├── model
│   └── Usuario.java                # Modelo de usuário
└── repository
    └── UsuarioRepository.java     # Repositório de usuários em memória
```

## Como Executar

### Pré-requisitos

- JDK 25
- Não é necessário instalar o Gradle separadamente — o projeto já inclui o Gradle wrapper.

### Rodando a aplicação

```bash
./gradlew bootRun
```

A API vai subir em `http://localhost:8080`.

### Rodando os testes

```bash
./gradlew test
```

## Endpoints da API

### Welcome

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `/`      | Retorna uma mensagem de boas-vindas |

### Usuários

| Método | Endpoint                | Descrição                          |
|--------|--------------------------|-------------------------------------|
| GET    | `/users`                 | Lista todos os usuários            |
| GET    | `/users/{id}`            | Busca um usuário pelo id           |
| GET    | `/users/login/{login}`   | Busca um usuário pelo login        |
| POST   | `/users`                 | Cria um novo usuário               |
| DELETE | `/users/{id}`            | Remove um usuário pelo id          |
| DELETE | `/users/login/{login}`   | Remove um usuário pelo login       |

> **Observação:** o `UsuarioRepository` atualmente é uma implementação mock em memória para fins de desenvolvimento — os dados não são persistidos entre requisições.

## Próximos Passos

- [ ] Adicionar persistência com banco de dados real (ex: Spring Data JPA + PostgreSQL/H2)
- [ ] Adicionar documentação com Swagger/OpenAPI
- [ ] Adicionar validação de requisições e tratamento de erros
- [ ] Substituir os `System.out.println` por logging estruturado (SLF4J)

## Autor

**Gustavo Bento**
[GitHub](https://github.com/Gustavo-Bento)