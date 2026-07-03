package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import main.java.br.edu.projeto.permissoes.domain.permission.Permission;

public class  InMemoryPermissionRepository implements PermissionRepository{
    private final Map<String, Permission> store;

    public InMemoryPermissionRepository(Map<String, Permission> store) {
        if(store == null){
            throw new IllegalArgumentException(
                "O armazenamento não pode ser nulo."
            );
        }
        this.store = store;
    }

    @Override
    public void save(Permission permission) {
        if(permission == null){
            throw new IllegalArgumentException(
                "Permissão Não Pode Ser Nula"
            );
        }
        store.put(permission.getName(), permission);
    }

    @Override
    public Optional<Permission> findByName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(
                "Nome Não Pode Ser Nulo"
            );
        }

        Permission permission = store.get(name);
        return Optional.ofNullable(permission);
    }

    @Override
    public List<Permission> findAll() {
        Collection<Permission> storedPermission = store.values();

        ArrayList<Permission> permissionsList = new ArrayList<>(storedPermission);

        return permissionsList;
    }

    @Override
    public void remove(String name) {
        if(name == null){
            throw new IllegalArgumentException(
                "Nome Inválido"
            );
        }
        store.remove(name);
    }


    
}  