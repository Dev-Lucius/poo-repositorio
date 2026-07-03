package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import main.java.br.edu.projeto.permissoes.domain.access.AccessAttempt;

// Implementa todos os métodos de AuditRepository filtrando attempts via streams.
public class InMemoryAuditRepository implements AuditRepository {
    private final List<AccessAttempt> attempts;

    public InMemoryAuditRepository(List<AccessAttempt> attempts) {
        if (attempts == null) {
            throw new IllegalArgumentException(
                    "Tentativas Não Podem Ser Nulas");
        }

        this.attempts = attempts;
    }

    @Override
    public void save(AccessAttempt attempt) {
        if (attempt == null) {
            throw new IllegalArgumentException("Tentativa não pode ser nula");
        }

        attempts.add(attempt);
    }

    @Override
    public List<AccessAttempt> findAll() {
        return new ArrayList<>(attempts);
    }

    // lista → stream → filtro → collect
    @Override
    public List<AccessAttempt> findAllAuthorized() {
        return attempts.stream()
                .filter(AccessAttempt::isAuthorized)
                .toList();
    }

    @Override
    public List<AccessAttempt> findAllDenied() {
        return attempts.stream()
                .filter(attempt -> !attempt.isAuthorized())
                .toList();
    }

    @Override
    public List<AccessAttempt> findByUser(String userId) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("UserId inválido");
        }

        return attempts.stream()
                .filter(a -> a.getUser().getId().equals(userId))
                .toList();
    }
}