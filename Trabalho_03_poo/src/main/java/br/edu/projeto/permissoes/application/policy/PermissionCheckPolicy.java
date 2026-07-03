package main.java.br.edu.projeto.permissoes.application.policy;

import main.java.br.edu.projeto.permissoes.domain.user.User;

public class PermissionCheckPolicy implements AccessPolicy {

    // Retorna true se usuário possui permissão com nome igual à ação
    @Override
    public boolean evaluate(User user, String action) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }

        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Ação inválida.");
        }

        return user.effectivePermissions().contains(action);

    }

    @Override
    public String reason() {
        return "Permissão Insuficiente";
    }
}