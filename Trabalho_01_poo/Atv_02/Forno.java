package Atv_02;

public class Forno {

    private final int volume;
    private final int tensao;
    private final int potencia;
    private final int largura;
    private final int altura;
    private final int profundidade;
    private static final int[] temperaturas = {50, 100, 150, 200, 220, 250, 300};
    private boolean ligado;
    private int indiceTemperatura;
    // Tempo restante em minutos — entre 0 e 120
    private int timer;

    /**
     * Construtor do Forno.
     *
     * @param volume       Volume interno em litros.
     * @param tensao       Tensão elétrica em volts (ex: 110 ou 220).
     * @param potencia     Potência em watts.
     * @param largura      Largura externa em centímetros.
     * @param altura       Altura externa em centímetros.
     * @param profundidade Profundidade externa em centímetros.
     */
    public Forno(int volume, int tensao, int potencia, int largura, int altura, int profundidade) {
        // Atributos de configuração — imutáveis após este ponto
        this.volume       = volume;
        this.tensao       = tensao;
        this.potencia     = potencia;
        this.largura      = largura;
        this.altura       = altura;
        this.profundidade = profundidade;

        // Estado inicial: forno desligado, temperatura mínima, sem timer
        this.ligado            = false;
        this.indiceTemperatura = 0;
        this.timer             = 0;
    }


    public boolean ligado() {
        return ligado;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            indiceTemperatura = 0; // começa sempre na temperatura mínima (50°C)
        }
    }

    public void desligar() {
        ligado            = false;
        indiceTemperatura = 0;
        timer             = 0;
    }

    public int temperatura() {
        if (!ligado) return 0;
        return temperaturas[indiceTemperatura];
    }
    public void aumentarTemperatura() {
    if (!ligado) {
        ligar();
        return;
    }

    if (indiceTemperatura < temperaturas.length - 1) {
        indiceTemperatura++;
    }
}
    public void diminuirTemperatura() {
        // Guarda de estado: só age se o forno estiver ligado
        if (!ligado) return;

        // Só decrementa se ainda não estiver na temperatura mínima
        if (indiceTemperatura > 0) {
            indiceTemperatura--;
        }
    }
    public void setTimer(int minutos) {
        if (minutos >= 1 && minutos <= 120) {
            timer = minutos;
        } else {
            // Lança exceção para tornar o erro visível ao chamador
            throw new IllegalArgumentException(
                "Timer inválido: deve estar entre 1 e 120 minutos. Recebido: " + minutos
            );
        }
    }

    public void tick() {
        // Guarda de estado: só age se o forno estiver ligado
        if (!ligado) return;

        if (timer > 0) {
            timer--;

            // Timer esgotado — desliga automaticamente
            if (timer == 0) {
                desligar();
                System.out.println("Timer finalizado. O forno foi desligado automaticamente.");
            }
        }
    }

    /**
     * Retorna o tempo restante do timer em minutos.
     *
     * @return minutos restantes, ou 0 se o timer não estiver ativo.
     */
    public int tempoRestante() {
        return timer;
    }
}