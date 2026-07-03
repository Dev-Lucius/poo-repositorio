package main.java.br.edu.projeto.permissoes.application.service;

import java.util.List;
import java.util.Optional;
import main.java.br.edu.projeto.permissoes.domain.permission.Permission;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.PermissionRepository;

public class PermissionService {
    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository){
        if(repository == null){
            throw new IllegalArgumentException("Repositório Não Pode ser Nulo");
        }
        this.repository = repository;
    }

    // Cria e persiste uma nova permissão; lança exceção se nome duplicado
    public Permission create(String name, String description){
        if(name == null || name.isBlank()){
            throw  new IllegalArgumentException("Nome não pode ser Nulo");
        }

        if(description == null || description.isBlank()){
            throw  new IllegalArgumentException("Descrição não pode ser Nulo");
        }
        
        // Verifica a Duplicidade
        if(repository.findByName(name).isPresent()){
            throw new IllegalArgumentException("Permissão Já Cadastrada");
        }

        var newPermission = new Permission(name, description);
        repository.save(newPermission);
        return newPermission;
    }

    // Busca permissão --> lança PermissionNotFoundException se não encontrada
    public Optional<Permission> findByName(String name){
        if(name == null || name.isBlank()){
            throw  new IllegalArgumentException("Nome não pode ser Nulo");
        }

        return repository.findByName(name);
    }

    // Lista todas as permissões cadastradas
    public List<Permission> listAll(){
        return repository.findAll();
    }

    // Método para Deletar uma Permissão
    public void delete(String name){
        if(name == null || name.isBlank()){
            throw  new IllegalArgumentException("Nome não pode ser Nulo");
        }

        findByName(name);

        repository.remove(name);
    }
}
