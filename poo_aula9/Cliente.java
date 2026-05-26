public class Cliente {

    String perfil;
    String nome;
    String email;
    CPF cpf;
    String rua;
    String numero;
    String bairro;
    String cep;
    String cidade;

    ClienteProfile profile;    // perfil, nome, email, cpf
    Endereco endereco;          // rua, numero, bairro, cep, cidade


    Cliente(String perfil) {
        this.perfil = "new";
    }

    public void promote() {
        if (isNew()) {
            this.perfil = "vip";
        } else if (isVip()) {
            this.perfil = "superpremium";
        }
    }

    public boolean isVip() {
        return this.perfil.equals("vip");
    }

    public boolean isSuperPremium() {
        return this.perfil.equals("superpremium");
    }

    public boolean isNew() {
        return this.perfil.equals("new");
    }
    
}
