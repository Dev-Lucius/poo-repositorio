package main.java.br.edu.projeto.permissoes.shared.exception;

public class PermissionNotFoundException extends DomainException{
    public PermissionNotFoundException(String permissionName){
        super("Permissão não Encontrada: " + permissionName);
    }
}
