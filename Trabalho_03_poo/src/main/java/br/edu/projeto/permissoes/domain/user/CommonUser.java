package main.java.br.edu.projeto.permissoes.domain.user;

public class CommonUser extends User{

    public CommonUser(String id, String username){
        super(id, username);
    }

    @Override
    public String getUserType() {
        return "COMMON";
    }
}