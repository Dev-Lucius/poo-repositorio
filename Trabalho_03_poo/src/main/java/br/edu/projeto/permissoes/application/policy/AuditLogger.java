package main.java.br.edu.projeto.permissoes.application.policy;

import main.java.br.edu.projeto.permissoes.domain.access.AccessAttempt;

public interface AuditLogger {

    void log(AccessAttempt attempt); // Registra tentativa de acesso

    void logChange(String entityType, String entityId, String description); // Registra mudança em usuário, papel ou permissão (auditoria de mudanças — opcional)
}
