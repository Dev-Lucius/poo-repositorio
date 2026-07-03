package main.java.br.edu.projeto.permissoes.domain.user;

public class AdminUser extends User{

    public AdminUser(String id, String username){
        super(id, username);
    }

    @Override
    public String getUserType() {
        return "ADMIN";
    }
}
