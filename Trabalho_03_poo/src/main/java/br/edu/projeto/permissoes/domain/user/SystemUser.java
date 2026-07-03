package main.java.br.edu.projeto.permissoes.domain.user;

public class SystemUser extends User{

    public SystemUser(String id, String username){
        super(id, username);
    }

    @Override
    public String getUserType() {
        return "System";
    }
}