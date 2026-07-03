package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.List;
import main.java.br.edu.projeto.permissoes.domain.role.Role;

public interface RoleRepository {
    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    void remove(String name);
}