package exemplo5;

public class Aplicacao {
    BancoDeDados bd;
    
    public Aplicacao(BancoDeDados bd) {
        this.bd = bd;
    }

    public void cadastrarPessoa() {
        System.out.println("CADASTRO PESSOA APP");
        this.bd.inserirPessoa();
    }

    public static void main(String[] args) {
        String ambiente = args[0];
        Aplicacao app;
        if (ambiente.equals("teste")) {
            app = new Aplicacao(new BancoDeDadosMemoria());
        } else {
            app = new Aplicacao(new BancoDeDadosReal());
        }

        app.cadastrarPessoa();
    }
}
