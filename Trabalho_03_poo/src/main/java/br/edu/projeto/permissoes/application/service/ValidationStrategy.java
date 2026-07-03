package main.java.br.edu.projeto.permissoes.application.service;

public interface ValidationStrategy<T> {
    // Executa validação sobre a entidade; lança DomainException em caso de falha
    void validate(T entity); 
}
