package associacao;

/**
 * Classe principal para demonstrar o conceito de ASSOCIAÇÃO em POO,
 * e como ela se combina com AGREGAÇÃO em um cenário real.
 *
 * CONCEITO — ASSOCIAÇÃO (Médico x Paciente):
 * Médico e Paciente são classes que se relacionam, mas existem de
 * forma completamente independente uma da outra.
 * Um Paciente pode existir sem nenhum Médico.
 * Um Médico pode existir sem nenhum Paciente.
 * A relação entre eles só existe no contexto de uma Consulta.
 *
 * CONCEITO — AGREGAÇÃO (Consulta x Médico x Paciente):
 * A Consulta depende de um Médico e de um Paciente para existir —
 * ela não faz sentido sem os dois. Porém, ao cancelar a Consulta,
 * o Médico e o Paciente continuam existindo normalmente.
 * Isso é Agregação: a Consulta referencia os objetos, mas não
 * controla o ciclo de vida deles.
 *
 * RESUMO DA DIFERENÇA NESTE EXEMPLO:
 * ┌─────────────────┬──────────────────────────────────────────┐
 * │ Associação      │ Médico e Paciente existem independentes  │
 * │ Agregação       │ Consulta depende dos dois, mas ao ser    │
 * │                 │ cancelada, eles continuam existindo      │
 * └─────────────────┴──────────────────────────────────────────┘
 */
public class Main {
    public static void main(String[] args) {

        // -------------------------------------------------------
        // ASSOCIAÇÃO — Criação independente dos objetos
        // Paciente e Médico são instanciados separadamente,
        // sem nenhuma dependência entre si neste momento.
        // Nenhum dos dois precisa do outro para existir.
        // -------------------------------------------------------
        Paciente p1 = new Paciente("Theo");
        Medico m1 = new Medico("Cris");

        // -------------------------------------------------------
        // AGREGAÇÃO — Consulta une os dois objetos
        // A Consulta é criada recebendo os objetos já existentes
        // como parâmetros — ela não cria o Médico nem o Paciente,
        // apenas os referencia internamente.
        // Isso é a essência da Agregação: o objeto "todo" (Consulta)
        // conhece as "partes" (Médico e Paciente), mas não as cria
        // nem as destrói.
        // -------------------------------------------------------
        Consulta c1 = new Consulta(p1, m1);

        // -------------------------------------------------------
        // CANCELANDO A CONSULTA — Ciclo de vida independente
        // Ao cancelar a Consulta, o objeto c1 perde o sentido,
        // mas p1 (Paciente) e m1 (Médico) continuam existindo
        // normalmente na memória — suas referências não foram
        // afetadas. Isso confirma a Agregação: as "partes" têm
        // ciclo de vida próprio, independente do "todo".
        // -------------------------------------------------------
        c1.cancelar();

        // Após o cancelamento, p1 e m1 ainda podem ser usados:
        // Ex: agendar uma nova consulta, acessar seus dados, etc.
        // O cancelamento da Consulta não os afeta em nada.
    }
}