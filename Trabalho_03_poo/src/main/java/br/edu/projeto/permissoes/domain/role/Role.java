package main.java.br.edu.projeto.permissoes.domain.role;

import main.java.br.edu.projeto.permissoes.domain.permission.Permission;
import main.java.br.edu.projeto.permissoes.domain.permission.Permissions;

public class Role {
    private final String name;
    private final Permissions permissions;

    public Role(String name, Permissions permissions) {
        // Validação de entrada
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome do papel não pode ser nulo ou vazio.");
        }
        if (permissions == null) {
            throw new IllegalArgumentException("As permissões não podem ser nulas.");
        }

        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    public void addPermission(Permission permission) {
        if (permission == null) {
            throw new IllegalArgumentException("Permissão Não Pode ser Nula");
        }

        permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        if (permission == null) {
            throw new IllegalArgumentException("Permissão Não Pode ser Nula");
        }
        permissions.remove(permission);
    }

    public Permissions getPermissions() {
        return permissions;
    }

    // equals(object) e hashCode --> Baseados em name
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Role))
            return false;

        Role other = (Role) obj;

        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {

        return "Role{" +
                "name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }

}