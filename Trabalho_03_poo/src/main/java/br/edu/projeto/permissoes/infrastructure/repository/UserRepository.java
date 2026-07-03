package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import main.java.br.edu.projeto.permissoes.domain.user.User;

public interface UserRepository {
    void save(User user);

    User findById(String id);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    void remove(String id);
}
