package main.java.br.edu.projeto.permissoes.shared.exception;

public class RoleNotFoundException extends DomainException{
    public RoleNotFoundException(String roleName){
        super("Papel Não Encontrado" + roleName);
    }
}
