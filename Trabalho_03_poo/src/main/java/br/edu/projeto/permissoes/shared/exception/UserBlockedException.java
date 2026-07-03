package main.java.br.edu.projeto.permissoes.shared.exception;

public class UserBlockedException extends DomainException {
    public UserBlockedException(String username){
        super("Usuário Bloqueado: " + username);
    }
}
