package main.java.br.edu.projeto.permissoes.app;

import java.util.*;
import main.java.br.edu.projeto.permissoes.application.policy.AccessPolicy;
import main.java.br.edu.projeto.permissoes.application.policy.PermissionCheckPolicy;
import main.java.br.edu.projeto.permissoes.application.service.AuthorizationServiceImpl;
import main.java.br.edu.projeto.permissoes.domain.permission.Permission;
import main.java.br.edu.projeto.permissoes.domain.permission.Permissions;
import main.java.br.edu.projeto.permissoes.domain.role.Role;
import main.java.br.edu.projeto.permissoes.domain.user.*;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // 1. REPOSITÓRIOS
        // =========================
        UserRepository userRepository =
                new InMemoryUserRepository(new HashMap<>());

        RoleRepository roleRepository =
                new InMemoryRoleRepository(new HashMap<>());

        PermissionRepository permissionRepository =
                new InMemoryPermissionRepository(new HashMap<>());

        AuditRepository auditRepository =
                new InMemoryAuditRepository(new ArrayList<>());

        // =========================
        // 2. PERMISSÕES
        // =========================
        Permission readUsers = new Permission("READ_USERS", "Ler usuários");
        Permission createUsers = new Permission("CREATE_USERS", "Criar usuários");

        permissionRepository.save(readUsers);
        permissionRepository.save(createUsers);

        Permissions adminPermissions =
                new Permissions(new HashSet<>(List.of(readUsers, createUsers)));

        // =========================
        // 3. ROLE
        // =========================
        Role adminRole = new Role("ADMIN", adminPermissions);
        roleRepository.save(adminRole);

        // =========================
        // 4. USUÁRIO
        // =========================
        User admin = new AdminUser(UUID.randomUUID().toString(), "admin");

        admin.assignRole(adminRole);
        userRepository.save(admin);

        // =========================
        // 5. POLÍTICAS
        // =========================
        List<AccessPolicy> policies = List.of(
                new PermissionCheckPolicy()
        );

        AuthorizationServiceImpl authService =
                new AuthorizationServiceImpl(auditRepository, policies);

        // =========================
        // 6. TESTES DE AUTORIZAÇÃO
        // =========================
        System.out.println("==== TESTE 1 ====");
        boolean result1 = authService.authorize(admin, "READ_USERS");
        System.out.println("Autorizado? " + result1);

        System.out.println("\n==== TESTE 2 ====");
        boolean result2 = authService.authorize(admin, "DELETE_USERS");
        System.out.println("Autorizado? " + result2);

        // =========================
        // 7. AUDITORIA
        // =========================
        System.out.println("\n==== LOGS DE AUDITORIA ====");
        auditRepository.findAll().forEach(System.out::println);
    }
}