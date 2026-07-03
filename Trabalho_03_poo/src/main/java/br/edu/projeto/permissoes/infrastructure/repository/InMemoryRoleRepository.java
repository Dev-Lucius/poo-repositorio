package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import main.java.br.edu.projeto.permissoes.domain.role.Role;

public class InMemoryRoleRepository implements RoleRepository{
    
    private final Map<String, Role> store;

    public InMemoryRoleRepository(Map<String, Role> store) {
        if(store == null){
            throw new IllegalArgumentException(
                "O armazenamento não pode ser nulo."
            );
        }
        this.store = store;
    }

    @Override
    public void save(Role role) {
        if(role == null){
            throw new IllegalArgumentException(
                "Papel Não Pode Ser Nulo"
            );
        }
        store.put(role.getName(), role);
    }

    @Override
    public Role findByName(String name) {

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(
                "Nome Não Pode Ser Nulo"
            );
        }

        Role role = store.get(name);
        return role;
    }

    @Override
    public List<Role> findAll() {
        Collection<Role> storedRole = store.values();

        ArrayList<Role> rolesList = new ArrayList<>(storedRole);

        return rolesList;
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
