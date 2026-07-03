package main.java.br.edu.projeto.permissoes.domain.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import main.java.br.edu.projeto.permissoes.domain.permission.Permissions;
import main.java.br.edu.projeto.permissoes.domain.role.Role;

public class Roles {
    private final Set<Role> items;

    // Coleção Inicial
    public Roles(Set<Role> items) {
        if (items == null) {
            throw new IllegalArgumentException(
                    "O conjunto de permissões não pode ser nulo.");
        }
        this.items = new HashSet<>(items);
    }

    // Coleção Vazia
    public Roles(){
        this.items = new HashSet<>();
    }

    // Adiciona um papel ao Conjunto
    public void assign(Role role) {
        if (role == null) {
            throw new IllegalArgumentException(
                    "O Pael do Conjunto não Pode ser Nulo");
        }
        items.add(role);
    }

    // Remove um papel do conjunto
    public void revoke(Role role) {
        if (role == null) {
            throw new IllegalArgumentException(
                    "O Pael do Conjunto não Pode ser Nulo");
        }
        items.remove(role);
    }

    // Verifica se o papel está associado
    public boolean contains(Role role) {
        return items.contains(role);
    }

    // Retorna visão imutável
    public Set<Role> toUnmodifiableSet() {
        return Collections.unmodifiableSet(items);
    }

    // Verifica se não há papéis associados
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Retorna a Quantidade total de Papéis
    public int size() {
        return items.size();
    }

    // Retorna união das permissões de todos os papéis
    public Permissions collectPermissions(){
        // Coleção Vazia --> Armazenerá todas as permissões encontradas em todas as
        // roles
        Permissions allPermissions = new Permissions(new HashSet<>());

        // Percorrendo todos os papéis que pertencem ao usuário
        // Exemplo...
        // ADMIN
        // MANAGER
        // OPERATOR
        // Ao final ... role.getPermissions() retorna esse conjunto.
        for (Role role : items) {
            // Aqui vamos unir as permissões desse papel com todas
            // as permissões já encontradas anteriormente.
            allPermissions = allPermissions.union(role.getPermissions());
        }

        // Depois que todos os papéis foram processados,
        // devolvemos a coleção contendo todas as permissões
        // do usuário.
        return allPermissions;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}