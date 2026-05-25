package Ex08;

public class Main {

    public static void main(String[] args) {

        // =========================
        // PLANO BÁSICO
        // =========================
        PlanoBasico basico = new PlanoBasico(
                "Lucas Oliveira",
                "lucas@gmail.com",
                29.90,
                1
        );

        System.out.println("=================================");
        System.out.println("CLIENTE: Plano Básico");
        System.out.println("=================================");

        basico.exibirPlano();

        System.out.println(
                "Mensalidade Final: R$ "
                + basico.calcularMensalidadeFinal()
        );

        basico.listarBeneficios();


        // =========================
        // PLANO PREMIUM
        // =========================
        PlanoPremium premium = new PlanoPremium(
                "Ana Souza",
                "ana@gmail.com",
                59.90,
                0.15
        );

        System.out.println("\n=================================");
        System.out.println("CLIENTE: Plano Premium");
        System.out.println("=================================");

        premium.exibirPlano();

        System.out.println(
                "Mensalidade Final: R$ "
                + premium.calcularMensalidadeFinal()
        );

        premium.listarBeneficios();


        // =========================
        // PLANO CORPORATIVO
        // =========================
        PlanoCorporativo corporativo = new PlanoCorporativo(
                "Empresa Tech",
                "contato@empresa.com",
                99.90,
                5
        );

        System.out.println("\n=================================");
        System.out.println("CLIENTE: Plano Corporativo");
        System.out.println("=================================");

        corporativo.exibirPlano();

        System.out.println(
                "Mensalidade Final: R$ "
                + corporativo.calcularMensalidadeFinal()
        );

        corporativo.listarBeneficios();


        // =========================
        // POLIMORFISMO
        // =========================
        System.out.println("\n=================================");
        System.out.println("TESTE DE POLIMORFISMO");
        System.out.println("=================================");

        PlanoAssinatura[] planos = {
                basico,
                premium,
                corporativo
        };

        for (PlanoAssinatura plano : planos) {

            System.out.println("\n-------------------------");

            plano.exibirPlano();

            System.out.println(
                    "Mensalidade: R$ "
                    + plano.calcularMensalidadeFinal()
            );

            plano.listarBeneficios();
        }
    }
}