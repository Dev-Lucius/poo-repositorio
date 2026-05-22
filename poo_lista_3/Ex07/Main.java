package Ex07;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=".repeat(60));
        System.out.println("       SISTEMA DE GERENCIAMENTO DE FROTA");
        System.out.println("=".repeat(60));

        // ─── 1. INSTANCIAÇÃO DOS VEÍCULOS ───────────────────────────
        Carro carro = new Carro("ABC-1234", "Honda Civic", 12.0);
        Caminhao caminhao = new Caminhao("XYZ-5678", "Volvo FH", 3.5, 0.4);
        Moto moto = new Moto("MOT-9999", "Yamaha MT-07", 22.0, 45);

        // ─── 2. EXIBIÇÃO DOS DADOS DE CADA VEÍCULO ──────────────────
        System.out.println("\n>>> DADOS CADASTRAIS DOS VEÍCULOS\n");
        carro.exibirDados();
        System.out.println();
        caminhao.exibirDados();
        System.out.println();
        moto.exibirDados();

        // ─── 3. TESTE DE AUTONOMIA ───────────────────────────────────
        double litrosTeste = 50.0;

        System.out.println("\n" + "─".repeat(60));
        System.out.printf(">>> AUTONOMIA COM %.0f LITROS%n", litrosTeste);
        System.out.println("─".repeat(60));

        System.out.printf("  %-10s → %.2f km%n",
                carro.getModelo(), carro.calcularAutonomia(litrosTeste));
        System.out.printf("  %-10s → %.2f km%n",
                caminhao.getModelo(), caminhao.calcularAutonomia(litrosTeste));
        System.out.printf("  %-10s → %.2f km%n",
                moto.getModelo(), moto.calcularAutonomia(litrosTeste));

        // ─── 4. COMPARAÇÃO DE CUSTO PARA UMA VIAGEM ─────────────────
        double distanciaViagem = 350.0; // km
        double precoCombustivel = 6.20; // R$/litro

        System.out.println("\n" + "─".repeat(60));
        System.out.printf(">>> CUSTO DA VIAGEM: %.0f km  |  Combustível: R$ %.2f/L%n",
                distanciaViagem, precoCombustivel);
        System.out.println("─".repeat(60));

        List<Veiculo> frota = new ArrayList<>();
        frota.add(carro);
        frota.add(caminhao);
        frota.add(moto);

        Veiculo maisEconomico = null;
        double menorCusto = Double.MAX_VALUE;

        for (Veiculo v : frota) {
            double custo = v.calcularCustoViagem(distanciaViagem, precoCombustivel);
            System.out.printf("  %-15s (%-13s) → R$ %8.2f%n",
                    v.getModelo(), v.getPlaca(), custo);

            if (custo < menorCusto) {
                menorCusto = custo;
                maisEconomico = v;
            }
        }

        System.out.println("\n  ✔  Veículo mais econômico para esta viagem:");
        System.out.printf("     %s [%s] — R$ %.2f%n",
                maisEconomico.getModelo(),
                maisEconomico.getPlaca(),
                menorCusto);

        // ─── 5. TESTE COM DIFERENTES CENÁRIOS DE DISTÂNCIA ──────────
        System.out.println("\n" + "─".repeat(60));
        System.out.println(">>> COMPARATIVO POR DISTÂNCIA (R$ 6,20/L)");
        System.out.println("─".repeat(60));
        System.out.printf("  %-8s | %-12s | %-12s | %-12s%n",
                "Dist(km)", carro.getModelo(), caminhao.getModelo(), moto.getModelo());
        System.out.println("  " + "-".repeat(52));

        int[] distancias = { 100, 250, 500, 1000 };
        for (int d : distancias) {
            System.out.printf("  %-8d | R$ %-9.2f | R$ %-9.2f | R$ %-9.2f%n",
                    d,
                    carro.calcularCustoViagem(d, precoCombustivel),
                    caminhao.calcularCustoViagem(d, precoCombustivel),
                    moto.calcularCustoViagem(d, precoCombustivel));
        }

        // ─── 6. TESTE DO FATOR DE CARGA DO CAMINHÃO ─────────────────
        System.out.println("\n" + "─".repeat(60));
        System.out.println(">>> IMPACTO DO FATOR DE CARGA NO CAMINHÃO");
        System.out.println("─".repeat(60));

        double[] fatores = { 0.0, 0.2, 0.4, 0.6, 0.8 };
        for (double fator : fatores) {
            caminhao.setFatorCarga(fator);
            System.out.printf("  Fator de carga: %.0f%%  →  Autonomia (50 L): %.2f km  |  Custo (350 km): R$ %.2f%n",
                    fator * 100,
                    caminhao.calcularAutonomia(50),
                    caminhao.calcularCustoViagem(350, precoCombustivel));
        }
        caminhao.setFatorCarga(0.4); // restaura valor original

        // ─── 7. TESTE DE RESTRIÇÃO DA MOTO ──────────────────────────
        System.out.println("\n" + "─".repeat(60));
        System.out.println(">>> RESTRIÇÃO DE CARGA NA MOTO");
        System.out.println("─".repeat(60));
        moto.autorizarMoto();
        moto.autorizarMoto();
        moto.autorizarMoto();

        // ─── 8. POLIMORFISMO — PROCESSAMENTO GENÉRICO ───────────────
        System.out.println("\n" + "─".repeat(60));
        System.out.println(">>> RELATÓRIO GERAL DA FROTA (polimorfismo)");
        System.out.println("─".repeat(60));
        for (Veiculo v : frota) {
            v.exibirDados();
            System.out.printf("  Custo estimado (350 km, R$6,20): R$ %.2f%n",
                    v.calcularCustoViagem(350, precoCombustivel));
            System.out.println();
        }

        System.out.println("=".repeat(60));
        System.out.println("               FIM DOS TESTES");
        System.out.println("=".repeat(60));
    }
}