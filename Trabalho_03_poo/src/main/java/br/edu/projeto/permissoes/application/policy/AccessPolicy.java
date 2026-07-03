package main.java.br.edu.projeto.permissoes.application.policy;

import main.java.br.edu.projeto.permissoes.domain.user.User;

public interface AccessPolicy {

    /**
     * Avalia se esta política permite que o usuário execute a ação.
     *
     * @param user   Usuário que deseja executar a ação.
     * @param action Nome da ação solicitada.
     * @return true se a política permitir o acesso; false caso contrário.
     */
    boolean evaluate(User user, String action);

    String reason(); // Retorna o Motivo de Negação
}