package main.java.br.edu.projeto.permissoes.shared.exception;

public class UserNotFoundException extends DomainException{

    public UserNotFoundException(String userId) {
        super("Usuário Não Encontrado: " + userId);
    }
    
}
