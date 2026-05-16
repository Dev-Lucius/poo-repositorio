import clinico.enums.*;
import clinico.model.Profissional;
import clinico.model.operacao.*;
import clinico.model.veiculo.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

        public static void main(String[] args) {
                
                // VEÍCULOS
                AmbulanciaSimples ambSimples = new AmbulanciaSimples(
                                "ABC-1234", "Fiat Ducato", 500, true, true);

                AmbulanciaUTI ambUTI = new AmbulanciaUTI(
                                "DEF-5678", "Mercedes Sprinter UTI", 600,
                                true, true, true);

                VanRefrigerada vanRefrig = new VanRefrigerada(
                                "GHI-9012", "Iveco Daily Refrigerada", 1000,
                                4.0, true); // temperatura atual: 4°C

                UtilitarioCarga utilitario = new UtilitarioCarga(
                                "JKL-3456", "Renault Master Carga", 1500,
                                8000, true);

                // PROFISSIONAIS
                Profissional motorista1 = new Profissional("Carlos Silva", "MOT-001", TipoProfissional.MOTORISTA);
                Profissional motorista2 = new Profissional("Ana Souza", "MOT-002", TipoProfissional.MOTORISTA);
                Profissional enfermeiro = new Profissional("Bruno Lima", "ENF-100", TipoProfissional.ENFERMEIRO);
                Profissional medico = new Profissional("Dra. Renata Melo", "CRM-999", TipoProfissional.MEDICO);
                Profissional farmaceutico = new Profissional("Pedro Costa", "CRF-321", TipoProfissional.FARMACEUTICO);
                Profissional tecnicoEq = new Profissional("Julia Ferreira", "TEC-555",
                                TipoProfissional.TECNICO_EQUIPAMENTO);

                // OPERAÇÕES --> Requisito do Trabalho
                List<OperacaoClinica> operacoes = new ArrayList<>();

                // 1. Medicamento com refrigeração e autorização farmacêutica
                TransporteMedicamentoControlado med1 = new TransporteMedicamentoControlado(
                                "OP-001", "Hospital Central", "Farmácia Norte",
                                15, "Dr. Marcus",
                                "Insulina Glargina", true, 2.0, 8.0, true);
                med1.setVeiculoDesignado(vanRefrig);
                med1.adicionarProfissional(motorista1);
                med1.adicionarProfissional(farmaceutico);
                operacoes.add(med1);

                // 2. Medicamento sem refrigeração
                TransporteMedicamentoControlado med2 = new TransporteMedicamentoControlado(
                                "OP-002", "Clínica Sul", "UBS Leste",
                                8, "Enfermeira Carla",
                                "Morfina 10mg", false, null, null, false);
                med2.setVeiculoDesignado(utilitario);
                med2.adicionarProfissional(motorista2);
                operacoes.add(med2);

                // 3. Amostra biológica urgência CRÍTICA com risco biológico
                TransporteAmostraBiologica amos1 = new TransporteAmostraBiologica(
                                "OP-003", "Laboratório Central", "Hospital Universitário",
                                22, "Lab Biotech",
                                "Sangue hemoculturas", NivelUrgencia.CRITICA, true, 45);
                amos1.setVeiculoDesignado(ambSimples);
                amos1.adicionarProfissional(motorista1);
                amos1.adicionarProfissional(enfermeiro);
                operacoes.add(amos1);

                // 4. Amostra biológica urgência BAIXA
                TransporteAmostraBiologica amos2 = new TransporteAmostraBiologica(
                                "OP-004", "Clínica Vida", "Laboratório Central",
                                5, "Dra. Paula",
                                "Urina rotina", NivelUrgencia.BAIXA, false, 120);
                amos2.setVeiculoDesignado(utilitario);
                amos2.adicionarProfissional(motorista2);
                operacoes.add(amos2);

                // 5. Equipamento pesado com técnico
                TransporteEquipamentoMedico equip1 = new TransporteEquipamentoMedico(
                                "OP-005", "Hospital Geral", "Clínica Cardio",
                                30, "Administração HG",
                                "Tomógrafo Siemens", 180, 950000.00, true, true);
                equip1.setVeiculoDesignado(utilitario);
                equip1.adicionarProfissional(motorista1);
                equip1.adicionarProfissional(tecnicoEq);
                operacoes.add(equip1);

                // 6. Equipamento leve sem técnico
                TransporteEquipamentoMedico equip2 = new TransporteEquipamentoMedico(
                                "OP-006", "Almoxarifado", "UPA Norte",
                                12, "Compras",
                                "Esfigmomanômetro digital", 3, 1200.00, false, false);
                equip2.setVeiculoDesignado(utilitario);
                equip2.adicionarProfissional(motorista2);
                operacoes.add(equip2);

                // 7. Remoção paciente CRÍTICO com UTI e médico
                RemocaoPaciente rem1 = new RemocaoPaciente(
                                "OP-007", "UPA Zona Leste", "Hospital São Lucas",
                                18, "UPA Zona Leste",
                                "José Antônio, 72 anos", 72,
                                NivelClinico.CRITICO, true, true, true);

                rem1.setVeiculoDesignado(ambUTI); // OK! Passando o objeto Veiculo normalmente
                rem1.adicionarProfissional(motorista1);
                rem1.adicionarProfissional(medico);
                rem1.adicionarProfissional(enfermeiro);
                operacoes.add(rem1);

                // 8. Remoção paciente ESTÁVEL
                RemocaoPaciente rem2 = new RemocaoPaciente(
                                "OP-008", "Clínica Repouso", "Hospital Central",
                                10, "Clínica Repouso",
                                "Maria Aparecida, 65 anos", 65,
                                NivelClinico.ESTAVEL, false, false, false);

                rem2.setVeiculoDesignado(ambSimples); // OK! Passando o objeto Veiculo normalmente
                rem2.adicionarProfissional(motorista2);
                operacoes.add(rem2);

                // Testando seu novo método:
                System.out.println("Veículo da Op 8: " + rem2.obterDescricaoVeiculo());

                // PROCESSAMENTO POLIMÓRFICO
                separador("VALIDAÇÃO E CICLO DE VIDA DAS OPERAÇÕES");

                for (OperacaoClinica op : operacoes) {
                        System.out.println("\n>>> " + op.getCodigo() + " — " + op.getTipo());
                        System.out.println("    Rastreamento: " + op.obterDescricaoRastreamento());
                        System.out.printf("    Custo estimado: R$ %.2f%n", op.calcularCusto());
                        System.out.println("    Prioridade: " + op.calcularPrioridade());
                        System.out.println("    " + op.gerarLogAuditoria());

                        op.aprovar();
                        op.iniciar();
                        op.concluir();
                }

                // RANKING POR PRIORIDADE
                // Ao invés de criar uma classe inteira para comparar duas operações, aqui tem-se...
                separador("RANKING DE OPERAÇÕES POR PRIORIDADE (decrescente)");

                List<OperacaoClinica> ordenadas = new ArrayList<>(operacoes);

                // .sort() ==> ordena elementos de um Array a partir de um critério específico
                // (a, b) -> ==> expressão lambda que representa os dois objetos da classe OperacaoClinica que serão subtraidos
                // b - a ==> Resultado Negativo: o primeiro elemento (a) fica antes.
                // b - a ==> Resultado Zero: a ordem deles não muda.
                // b - a ==> Resultado Positivo: o segundo elemento (b) passa para a frente do primeiro (a).
                ordenadas.sort((a, b) -> b.calcularPrioridade() - a.calcularPrioridade());

                // Imprimindo cada Operacao
                for (OperacaoClinica op : ordenadas) {
                        System.out.printf(" [Prioridade %2d] %s - %s%n",
                                op.calcularPrioridade(), op.getCodigo(), op.getTipo());
                }
                

                // CUSTO TOTAL
                separador("CUSTO TOTAL DA SIMULAÇÃO");

                double total = operacoes.stream().mapToDouble(OperacaoClinica::calcularCusto).sum();
                System.out.printf("  Total de %d operações: R$ %.2f%n", operacoes.size(), total);

                // TESTE DE REGRAS DE STATUS
                separador("TESTE DE REGRAS DE STATUS (casos de erro esperados)");

                RemocaoPaciente remTeste = new RemocaoPaciente(
                                "OP-999", "Origem", "Destino", 5, "Teste",
                                "Paciente Teste", 30, NivelClinico.GRAVE,
                                false, false, false); // GRAVE sem médico → inválida
                remTeste.setVeiculoDesignado(ambSimples);
                remTeste.adicionarProfissional(motorista1); // sem médico

                remTeste.iniciar(); // erro: não aprovada
                remTeste.aprovar();
                remTeste.iniciar(); // erro: inválida (sem médico para paciente GRAVE)
                remTeste.concluir(); // erro: não em execução
                remTeste.cancelar(); // ok: pode cancelar se não concluída
                remTeste.cancelar(); // erro: já cancelada... na verdade cancelar não verifica CANCELADA, mas vamos
                                     // testar concluída
        }

        // 
        private static void separador(String titulo) {
                System.out.println("\n" + "=".repeat(70));
                System.out.println("  " + titulo);
                System.out.println("=".repeat(70));
        }
}
