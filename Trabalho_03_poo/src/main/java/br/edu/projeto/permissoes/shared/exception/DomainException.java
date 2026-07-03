package main.java.br.edu.projeto.permissoes.shared.exception;

// Exceção base de domínio. Todas as demais a estendem.
public class DomainException extends RuntimeException{
    public DomainException(String message) { 
        super(message); 
    }
}
