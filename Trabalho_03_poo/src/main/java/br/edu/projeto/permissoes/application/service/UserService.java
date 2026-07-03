package main.java.br.edu.projeto.permissoes.application.service;

import java.util.List;
import java.util.UUID;
import main.java.br.edu.projeto.permissoes.domain.permission.Permissions;
import main.java.br.edu.projeto.permissoes.domain.role.Role;
import main.java.br.edu.projeto.permissoes.domain.user.AdminUser;
import main.java.br.edu.projeto.permissoes.domain.user.CommonUser;
import main.java.br.edu.projeto.permissoes.domain.user.SystemUser;
import main.java.br.edu.projeto.permissoes.domain.user.User;
import main.java.br.edu.projeto.permissoes.domain.user.UserStatus;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.RoleRepository;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.UserRepository;
import main.java.br.edu.projeto.permissoes.shared.exception.UserNotFoundException;

public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // Cria e Persiste um ADMIN
    public AdminUser createAdmin(String username){
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException("Nome para Usuário Inválido");
        }

        String id = UUID.randomUUID().toString();

        AdminUser newAdmUser = new AdminUser(id, username);
        userRepository.save(newAdmUser);
        return newAdmUser;
    }

    // Cria e Persiste um Usuário Comum
    public CommonUser createCommon(String username){
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException("Nome para Usuário Inválido");
        }

        String id = UUID.randomUUID().toString();

        CommonUser newCommonUser = new CommonUser(id, username);
        userRepository.save(newCommonUser);
        return newCommonUser;
    }

    // Cria e Persiste um Usuário de Sistema
    public SystemUser createSystem(String username){
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException("Nome para Usuário Inválido");
        }

        String id = UUID.randomUUID().toString();

        SystemUser newSystemUser = new SystemUser(id, username);
        userRepository.save(newSystemUser);
        return newSystemUser;
    }

    // Associa um Papel ao Usuário
    public void assignRole(String userId, String roleName){
        // Validações
        if(userId == null){
            throw new IllegalArgumentException("Id de Usuário Inválido");
        }

        if(roleName == null || roleName.isBlank()){
            throw new IllegalArgumentException("Nome para Papel Inválido");
        }

        // Busca um Usuário
        User user = userRepository.findById(userId);

        // Busca um Papel
        Role role = roleRepository.findByName(roleName);

        // Associa um papel ao Usuário
        user.assignRole(role);

        // Salva esse usuário
        userRepository.save(user);
    }

    // Remove papel do usuário
    public void revokeRole(String userId, String roleName){
        // Validações
        if(userId == null){
            throw new IllegalArgumentException("Id de Usuário Inválido");
        }

        if(roleName == null || roleName.isBlank()){
            throw new IllegalArgumentException("Nome para Papel Inválido");
        }

        // Busca um Usuário
        User user = userRepository.findById(userId);

        // Busca um Papel
        Role role = roleRepository.findByName(roleName);

        // Remove um Papel do Usuário
        user.revokeRole(role);

        // Salve esse Usuário pelo ID
        userRepository.remove(userId);
    }

    // Bloqueia o Usuário
    public void block(String userId){
        // Validações
        if(userId == null){
            throw new IllegalArgumentException("Id de Usuário Inválido");
        }

        // Busca um Usuário
        User user = userRepository.findById(userId);
        
        // Atualiza o Status do Usuário
        user.setStatus(UserStatus.BLOCKED);
    }

    // Desbloqueia o usuário
    public void unblock(String userId){
        // Validações
        if(userId == null){
            throw new IllegalArgumentException("Id de Usuário Inválido");
        }

        // Busca um Usuário
        User user = userRepository.findById(userId); 

        // Atualiza o Status do Usuário
        user.setStatus(UserStatus.ACTIVE);
    }

    // Busca usuário 
    // Lança UserNotFoundException se não encontrado
    public User findById(String id){
        if(id == null){
            throw new UserNotFoundException("Id de Usuário Inválido");
        }
        
        if(userRepository.findById(id) == null){
            throw new IllegalArgumentException("Usuário Não Encontrado");
        }
        return userRepository.findById(id);
    }

    // Retorna permissões efetivas do usuário
    public Permissions listEffectivePermissions(String userId) throws IllegalAccessException{
        if(userId == null){
            throw new IllegalArgumentException("Id de Usuário Inválido");
        }

        User user = findById(userId);
        return user.effectivePermissions();
    }

    // Listar Todos os Usuários
    public List<User> listAll(){
        return userRepository.findAll();
    }
}
