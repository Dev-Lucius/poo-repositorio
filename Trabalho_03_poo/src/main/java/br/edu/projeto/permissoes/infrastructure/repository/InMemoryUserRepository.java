package main.java.br.edu.projeto.permissoes.infrastructure.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import main.java.br.edu.projeto.permissoes.domain.user.User;

// Implementa todos os métodos de UserRepository operando sobre store.
public class InMemoryUserRepository implements UserRepository {

    // Mapa id → User para acesso O(1)
    private final Map<String, User> store;

    public InMemoryUserRepository(Map<String, User> store) {
        if (store == null) {
            throw new IllegalArgumentException(
                    "O armazenamento não pode ser nulo.");
        }
        this.store = store;
    }

    @Override
    public void save(User user) {
        if(user == null){
            throw new IllegalArgumentException(
                "Usuário Inválido"
            );
        }

        String id = user.getId();
        store.put(id, user);
    }

    @Override
    public User findById(String id) {
        if(id == null){
            throw new IllegalArgumentException(
                "Id Inválido"
            );
        }

        User user = store.get(id);
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException(
                "Usuário Inválido"
            );
        }

        for (User user : store.values()) {
            if(user.getUsername().equals(username)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        Collection<User> storedUsers = store.values();

        ArrayList<User> usersList = new ArrayList<>(storedUsers);

        return usersList;
    }

    @Override
    public void remove(String id) {
        if(id == null){
            throw new IllegalArgumentException(
                "Id Inválido"
            );
        }
        store.remove(id);
    }

}