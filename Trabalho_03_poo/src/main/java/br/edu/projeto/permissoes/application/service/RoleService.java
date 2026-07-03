package main.java.br.edu.projeto.permissoes.application.service;

import java.util.HashSet;
import java.util.List;
import main.java.br.edu.projeto.permissoes.domain.permission.Permission;
import main.java.br.edu.projeto.permissoes.domain.permission.Permissions;
import main.java.br.edu.projeto.permissoes.domain.role.Role;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.PermissionRepository;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.RoleRepository;

public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private Permission permission;

    public RoleService(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    // Cria e Persiste um Novo Papel
    public Role create(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name Inválido");
        }

        if (roleRepository.findByName(name).hasPermission(permission)) {
            throw new IllegalArgumentException("Já existe um Papel com Esse Nome");
        }

        Role role = new Role(name, new Permissions(new HashSet<>()));

        roleRepository.save(role);

        return role;
    }

    // Associa uma Permissão Ao Papel
    public void addPermission(String roleName, String permissionName) {
        
        Role role = findByName(roleName);

        permissionRepository.findByName(permissionName);

        role.addPermission(permission);
        roleRepository.save(role);
    }

    // Remove uma Permissão ao Papel
    public void removePermission(String roleName, String permissionName) {
    }

    // Busca um Papel --> lança RoleNotFoundException se não encontrado
    public Role findByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name Inválido");
        }

        return roleRepository
            .findByName(name);
    }

    // Lista todos os Papéis
    public List<Role> listAll() {
        return roleRepository.findAll();
    }
}
