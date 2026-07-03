package main.java.br.edu.projeto.permissoes.domain.user;

import main.java.br.edu.projeto.permissoes.domain.permission.Permissions;
import main.java.br.edu.projeto.permissoes.domain.permission.Permission;
import main.java.br.edu.projeto.permissoes.domain.role.Role;

public abstract class User {

    private final String id;
    private final String username;
    private UserStatus status;
    private final Roles roles;

    public User(String id, String username) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id não pode ser Nulo");
        }
        this.id = id;

        validateUsername(username);
        this.username = username;
        this.roles = new Roles();
    }

    // Validador de Nome
    private void validateUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username Inválido");
        }
    }

    // Setter para o Status
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    // Getter para o ID
    public String getId() {
        return id;
    }

    // Getter para o Username
    public String getUsername() {
        return username;
    }

    // Método para Verificar se um Usuário está bloqueado
    public boolean isBlocked() {
        return status == UserStatus.BLOCKED;
    }

    // Método para Bloquear um usuário
    public void block() {
        if (isBlocked()) {
            throw new IllegalArgumentException("Usuário Já Está Bloqueado");
        }
        status = UserStatus.BLOCKED;
    }

    // Método para Ativar um Usuário
    // Faz o Oposto de block()
    public void unblock() {
        if (!isBlocked()) {
            throw new IllegalArgumentException("Usuário Já Está Ativado");
        }
        this.status = UserStatus.ACTIVE;
    }

    // Associa um Papel ao Usuário
    public void assignRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("O papel do Usuário Não Pode ser Nulo");
        }
        roles.assign(role);
    }

    // Remove papel do usuário
    public void revokeRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("O papel do Usuário Não Pode ser Nulo");
        }
        roles.revoke(role);
    }

    // Delega para roles.collectPermissions()
    public Permissions effectivePermissions(){
        return roles.collectPermissions();
    }

    // Verifica se o usuário possui a permissão efetiva
    public boolean hasPermission(Permission permission) throws IllegalAccessException {
        if (permission == null) {
            throw new IllegalArgumentException("Permissão inválida.");
        }

        return effectivePermissions().contains(permission);
    }

    // Abstrato --> Retorna o Tipo de Usuário
    public abstract String getUserType();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", status=").append(status);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}