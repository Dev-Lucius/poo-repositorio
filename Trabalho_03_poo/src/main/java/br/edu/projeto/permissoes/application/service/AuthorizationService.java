package main.java.br.edu.projeto.permissoes.application.service;

import main.java.br.edu.projeto.permissoes.domain.user.User;

public interface AuthorizationService {
    // Avalia se o usuário pode executar a ação; registra o resultado na auditoria
    boolean authorize(User user, String action);
}
