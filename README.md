# Spring Web API

Uma API REST simples construída com Spring Boot para gerenciamento de usuários, desenvolvida como projeto de estudo/prática.

## Tecnologias

- **Java 25**
- **Spring Boot 4.1.1**
- **Gradle** (com wrapper)
- **springdoc-openapi** (documentação Swagger/OpenAPI)
- **JUnit 5** para testes

## Estrutura do Projeto

```
src/main/java/com/bento/springwebapi
├── SpringWebApiApplication.java   # Ponto de entrada da aplicação
├── controller
│   ├── WelcomeController.java     # Endpoint de boas-vindas
│   └── UsuarioController.java     # Endpoints CRUD de usuários
├── doc
│   └── SwaggerConfig.java         # Configuração do Swagger/OpenAPI
├── handler
│   ├── GlobalExceptionHandler.java     # Tratamento global de exceções
│   ├── BusinessException.java          # Exceção base para regras de negócio
│   ├── CampoObrigatorioException.java  # Exceção para campos obrigatórios ausentes
│   └── ResponseError.java              # Modelo padrão de resposta de erro
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

### Documentação da API (Swagger)

Com a aplicação rodando, a documentação interativa fica disponível em:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- JSON da especificação OpenAPI: `http://localhost:8080/v3/api-docs`

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
| PUT    | `/users`                 | Atualiza um usuário existente      |
| DELETE | `/users/{id}`            | Remove um usuário pelo id          |
| DELETE | `/users/login/{login}`   | Remove um usuário pelo login       |

> **Observação:** o `UsuarioRepository` atualmente é uma implementação mock em memória para fins de desenvolvimento — os dados não são persistidos entre requisições.

## Tratamento de Erros

A API possui um tratamento global de exceções (`GlobalExceptionHandler`), que padroniza todas as respostas de erro no seguinte formato:

```json
{
  "status": "error",
  "error": "O campo login é obrigatório",
  "statusCode": 400
}
```

- **`CampoObrigatorioException`**: lançada quando um campo obrigatório (ex: `login`, `id`) não é informado. Gera automaticamente a mensagem `"O campo {campo} é obrigatório"` com status `400 Bad Request`.
- **`BusinessException`**: classe base para qualquer regra de negócio violada, permitindo mensagem, status HTTP e argumentos de formatação customizados.
- **Erros inesperados**: retornam uma mensagem genérica com status `500 Internal Server Error`, evitando expor detalhes internos da aplicação.

As mensagens genéricas são centralizadas em `src/main/resources/messages.properties`.

## Próximos Passos

- [ ] Adicionar persistência com banco de dados real (ex: Spring Data JPA + PostgreSQL/H2)
- [ ] Adicionar validação de requisições (Bean Validation) com respostas de erro detalhadas por campo
- [ ] Substituir os `System.out.println` por logging estruturado (SLF4J)
- [ ] Adicionar testes automatizados para os endpoints e para o tratamento de exceções

## Autor

**Gustavo Bento**
[GitHub](https://github.com/Gustavo-Bento)