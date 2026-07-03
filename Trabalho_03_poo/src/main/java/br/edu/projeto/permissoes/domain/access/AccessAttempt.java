package main.java.br.edu.projeto.permissoes.domain.access;

import java.time.LocalDateTime;
import main.java.br.edu.projeto.permissoes.domain.user.User;

public class AccessAttempt {

    private final User user;
    private final String action;
    private final AcessResult result;
    private final String reason;
    private final LocalDateTime timestamp;

    public AccessAttempt(User user, String action, AcessResult result, String reason) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário Não Pode ser Nulo");
        }
        this.user = user;

        if (action == null) {
            throw new IllegalArgumentException("Ação Não Pode ser Nulo");
        }
        this.action = action;

        if (result == null) {
            throw new IllegalArgumentException("Resultado Não Pode ser Nulo");
        }
        this.result = result;

        if (reason == null) {
            throw new IllegalArgumentException("Motivo Não Pode ser Nulo");
        }
        this.reason = reason;

        this.timestamp = LocalDateTime.now();
    }
    
    // Getter de Usuário
    public User getUser() {
        return user;
    }

    // Getter de Ação
    public String getAction() {
        return action;
    }

    // Getter de Resultado
    public AcessResult getResult() {
        return result;
    }

    // Getter de Motivo
    public String getReason() {
        return reason;
    }

    // Getter do Momento do registro
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Verifica se a Tentavida de Acesso foi Autorizada
    public boolean isAuthorized(){
        return result == AcessResult.AUTHORIZED;
    }

    // ToString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccessAttempt{");
        sb.append("user=").append(user);
        sb.append(", action=").append(action);
        sb.append(", result=").append(result);
        sb.append(", reason=").append(reason);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }

    
}
