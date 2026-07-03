package main.java.br.edu.projeto.permissoes.application.policy;

import main.java.br.edu.projeto.permissoes.domain.user.User;

public class BlockedUserPolicy implements  AccessPolicy{

    @Override
    public boolean evaluate(User user, String action) {
        return !user.isBlocked();
    }

    @Override
    public String reason() {
        return "Usuário Bloqueado";
    }
    
}
