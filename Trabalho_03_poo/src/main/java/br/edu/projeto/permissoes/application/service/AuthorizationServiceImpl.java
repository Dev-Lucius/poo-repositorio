package main.java.br.edu.projeto.permissoes.application.service;

import java.util.List;

import main.java.br.edu.projeto.permissoes.application.policy.AccessPolicy;
import main.java.br.edu.projeto.permissoes.domain.access.AccessAttempt;
import main.java.br.edu.projeto.permissoes.domain.access.AcessResult;
import main.java.br.edu.projeto.permissoes.domain.user.User;
import main.java.br.edu.projeto.permissoes.infrastructure.repository.AuditRepository;

// Avalia se um Usuário pode executar uma ação
// Registra o Resultado na Auditoria

/**
 * Fluxo Interno de authorize
 * 1. Itera policies (guard clause: primeira que negar, para)
 * 2. Cria AccessAttempt com resultado e motivo.
 * 3. Persiste em auditRepository
 * 4. Retorna true/false.
 */
public class AuthorizationServiceImpl implements AuthorizationService {

    private final List<AccessPolicy> policies;
    private final AuditRepository auditRepository;

    public AuthorizationServiceImpl(AuditRepository auditRepository, List<AccessPolicy> policies) {
        this.auditRepository = auditRepository;
        this.policies = policies;
    }

    // Avalia cada política; registra tentativa; retorna resultado
    @Override
    public boolean authorize(User user, String action) {

        if (user == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }

        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Ação inválida.");
        }

        for (AccessPolicy policy : policies) {

            if (!policy.evaluate(user, action)) {

                AccessAttempt attempt = new AccessAttempt(
                        user,
                        action,
                        AcessResult.DENIED,
                        policy.reason());

                auditRepository.save(attempt);

                return false;
            }
        }

        AccessAttempt attempt = new AccessAttempt(
                user,
                action,
                AcessResult.AUTHORIZED,
                "Acesso autorizado.");

        auditRepository.save(attempt);

        return true;
    }

}
