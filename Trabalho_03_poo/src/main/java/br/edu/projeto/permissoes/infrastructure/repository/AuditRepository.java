package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.List;
import main.java.br.edu.projeto.permissoes.domain.access.AccessAttempt;

public interface AuditRepository {
    void save(AccessAttempt attempt);

    List<AccessAttempt> findAll();

    List<AccessAttempt> findAllAuthorized();

    List<AccessAttempt> findAllDenied();

    List<AccessAttempt> findByUser(String userId);
}
