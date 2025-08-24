# ProjectAPI

Projeto de exemplo de uma API REST utilizando Spring Boot.

## Descrição

Esta aplicação implementa uma API para gerenciamento de usuários, permitindo operações de criação, consulta, atualização e remoção de usuários em memória.

## Estrutura do Projeto

- **src/main/java/com/API/ProjectAPI/model/User.java**  
  Define a entidade `User` com os campos `name` e `ID`.

- **src/main/java/com/API/ProjectAPI/service/ServiceApplication.java**  
  Serviço responsável pela lógica de negócio relacionada aos usuários, incluindo métodos para criar, buscar, atualizar e remover usuários.

- **src/main/java/com/API/ProjectAPI/controller/UserController.java**  
  Controlador REST que expõe os endpoints para manipulação dos usuários.

- **src/main/java/com/API/ProjectAPI/ProjectApiApplication.java**  
  Classe principal para inicialização da aplicação Spring Boot.

## Endpoints

| Método | Endpoint      | Descrição                        |
|--------|--------------|----------------------------------|
| GET    | `/users`     | Lista todos os usuários          |
| GET    | `/users/{id}`| Busca usuário pelo ID            |
| POST   | `/users`     | Cria um novo usuário             |
| PUT    | `/users/{id}`| Atualiza um usuário existente    |
| DELETE | `/users/{id}`| Remove um usuário pelo ID        |

## Exemplo de Requisição

### Criar Usuário

```json
POST /users
{
  "name": "João"
}
