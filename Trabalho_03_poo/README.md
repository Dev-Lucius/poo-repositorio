# Sistema de Gerenciamento de Permissões

## Descrição

Projeto desenvolvido em Java aplicando Programação Orientada a Objetos,
SOLID e Object Calisthenics para implementar um sistema de controle de
acesso baseado em usuários, papéis (roles) e permissões.

## Objetivos

-   Modelar usuários, papéis e permissões.
-   Autorizar ações por políticas de acesso.
-   Registrar auditoria das tentativas de acesso.
-   Demonstrar arquitetura em camadas e boas práticas de POO.

## Arquitetura

```
src/main/java/
 └── br.edu.projeto.permissoes
      ├── app/
      │    └── Main.java
      ├── domain/
      │    ├── user/
      │    │    ├── User.java              ← classe abstrata (base)
      │    │    ├── AdminUser.java
      │    │    ├── CommonUser.java
      │    │    ├── SystemUser.java
      │    │    ├── UserStatus.java        ← enum
      │    │    └── Roles.java             ← coleção de primeira classe
      │    ├── role/
      │    │    └── Role.java
      │    ├── permission/
      │    │    ├── Permission.java
      │    │    └── Permissions.java       ← coleção de primeira classe
      │    └── access/
      │         ├── AccessAttempt.java
      │         └── AccessResult.java     ← enum
      ├── application/
      │    ├── service/
      │    │    ├── UserService.java
      │    │    ├── RoleService.java
      │    │    ├── PermissionService.java
      │    │    └── AuthorizationServiceImpl.java
      │    └── policy/
      │         ├── BlockedUserPolicy.java
      │         └── PermissionCheckPolicy.java
      ├── infrastructure/
      │    └── repository/
      │         ├── InMemoryUserRepository.java
      │         ├── InMemoryRoleRepository.java
      │         ├── InMemoryPermissionRepository.java
      │         └── InMemoryAuditRepository.java
      └── shared/
           └── exception/
                ├── DomainException.java
                ├── UserNotFoundException.java
                ├── UserBlockedException.java
                ├── RoleNotFoundException.java
                └── PermissionNotFoundException.java
```

### Camadas

-   **domain**: entidades e regras de negócio.
-   **application**: casos de uso, serviços e políticas.
-   **infrastructure**: repositórios em memória.
-   **shared**: exceções compartilhadas.
-   **app**: ponto de entrada (`Main`).

## Modelo de Domínio

### User

Classe abstrata que representa um usuário do sistema.

Especializações: - AdminUser - CommonUser - SystemUser

### Role

Representa um papel atribuído ao usuário.

### Permission

Representa uma única permissão.

### Permissions

Coleção de primeira classe responsável por encapsular operações sobre
permissões.

### Roles

Coleção de primeira classe responsável por encapsular os papéis de um
usuário.

### AccessAttempt

Representa uma tentativa de acesso contendo: - usuário - ação -
resultado - motivo - data/hora

## Fluxo de Autorização

``` text
Usuário
   ↓
Roles
   ↓
Permissions
   ↓
AccessPolicy
   ↓
AuthorizationService
   ↓
AuditRepository
```

## Padrões e Princípios

### SOLID

-   SRP: responsabilidades separadas entre entidades, serviços e
    repositórios.
-   OCP: novas políticas podem ser adicionadas sem alterar o serviço de
    autorização.
-   LSP: subclasses de User substituem a classe base.
-   ISP: interfaces específicas para cada repositório.
-   DIP: serviços dependem de interfaces.

### Object Calisthenics

-   Coleções de primeira classe (`Roles` e `Permissions`);
-   Classes pequenas e coesas;
-   Encapsulamento das regras de negócio;
-   Métodos com responsabilidade única.

## Estrutura dos Repositórios

-   UserRepository
-   RoleRepository
-   PermissionRepository
-   AuditRepository

Implementações: - InMemoryUserRepository - InMemoryRoleRepository -
InMemoryPermissionRepository - InMemoryAuditRepository

## Funcionalidades

-   Cadastro de usuários
-   Cadastro de papéis
-   Cadastro de permissões
-   Associação de papéis aos usuários
-   Associação de permissões aos papéis
-   Autorização baseada em políticas
-   Auditoria de tentativas de acesso

## Tecnologias

-   Java
-   Programação Orientada a Objetos
-   Collections Framework
-   Streams API
-   UUID

## Execução

``` bash
git clone <repositorio>
cd projeto
./mvnw compile
./mvnw exec:java
```

## Autor

Projeto acadêmico desenvolvido para a disciplina de Programação
Orientada a Objetos.
