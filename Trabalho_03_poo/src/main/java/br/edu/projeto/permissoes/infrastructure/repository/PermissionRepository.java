package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import main.java.br.edu.projeto.permissoes.domain.permission.Permission;

public interface PermissionRepository {
    void save(Permission permission);

    Optional<Permission> findByName(String name);

    List<Permission> findAll();

    void remove(String name);
}
