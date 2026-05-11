package Atv03;

public class Main {

    public static void main(String[] args) {

        // Chamando o Singleton duas vezes
        ConfiguracaoSistema singleton1 = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema singleton2 = ConfiguracaoSistema.getInstance();

        // Usando o método da classe
        singleton1.exibirMensagem();
        singleton2.exibirMensagem();

        // Verificando se as duas referências apontam para o mesmo objeto
        if (singleton1 == singleton2) {
            System.out.println("As duas referências apontam para a mesma instância.");
        } else {
            System.out.println("Instâncias diferentes.");
        }

    }
}