package Atv03;

public class ConfiguracaoSistema {

    // Instância única da classe
    private static ConfiguracaoSistema instancia;

    // Construtor privado
    private ConfiguracaoSistema() {
        System.out.println("Instância Singleton criada!");
    }

    // Método para acessar a instância única
    public static ConfiguracaoSistema getInstance() {

        if (instancia == null) {
            instancia = new ConfiguracaoSistema();
        }

        return instancia;
    }

    // Método exemplo (utilidade prática)
    public void exibirMensagem() {
        System.out.println("Sistema configurado com sucesso.");
    }
}