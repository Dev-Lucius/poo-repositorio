package main.java.br.edu.projeto.permissoes.domain.permission;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Coleção de Primeira Classe --> Conjunto de Permissões
// Object Calisthenics - Regra n° 4
public class Permissions {
    private final Set<Permission> items;

    // Coleção Inicial
    public Permissions(Set<Permission> items) {
        if (items == null) {
            throw new IllegalArgumentException(
                    "O conjunto de permissões não pode ser nulo.");
        }
        this.items = new HashSet<>(items);
    }

    // Coleção Vazia
    public Permissions() {
        this.items = new HashSet<>();
    }

    // Adiciona uma Permissão ao Conjunto
    public void add(Permission permission) {
        if (permission == null) {
            throw new IllegalArgumentException("A permissão Não pode Ser Nula");
        }
        System.out.println("Permissão Adicionada com Sucesso");
        items.add(permission);
    }

    // Remove uma Permissão do Conjunto
    public void remove(Permission permission) {
        if (permission == null) {
            throw new IllegalArgumentException("Adicione uma Permissão para Remover");
        }
        items.remove(permission);
    }

    // Verifica se a Permissão Existe
    public boolean contains(Permission permission) {
        return items.contains(permission);
    }

    // Overload de Contains
    public boolean contains(String permissionName) {

        if (permissionName == null || permissionName.isBlank()) {
            throw new IllegalArgumentException(
                    "Nome da permissão inválido.");
        }

        for (Permission permission : items) {

            if (permission.matches(permissionName)) {
                return true;
            }
        }

        return false;
    }

    // Retorna uma Nova Instância com a União dos dois conjuntos
    public Permissions union(Permissions other) {
        if (other == null) {
            throw new IllegalArgumentException("O Conjunto Informado não pode ser Nulo");
        }
        Set<Permission> union = new HashSet<>(items);
        union.addAll(other.items);
        return new Permissions(union);
    }

    // Retorna visão Imutável do Conjunto
    public Set<Permission> asSet() {
        return Collections.unmodifiableSet(items);
    }

    // Verifica se está Vazio
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Retorna a Quantidade de Permissões
    public int size() {
        return items.size();
    }

    // toString
    @Override
    public String toString() {
        return items.toString();
    }
}
