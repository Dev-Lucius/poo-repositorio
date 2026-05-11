package poo_ex16;

public class Consulta {
    
    private String observacao;
    private Paciente paciente;
    private Medico medico;

    public Paciente getPaciente() {
        return paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public String getObservacao() {
        return observacao;
    }

    public Consulta(String observacao, Paciente paciente, Medico medico){

        if(paciente == null){
            throw new IllegalArgumentException("Paciente não pode ser nulo");
        }

        if(medico == null){
            throw new IllegalArgumentException("Médico não pode ser nulo");
        }

        setObservacao(observacao);
        this.paciente = paciente;
        this.medico = medico;
    }

    public void setObservacao(String observacao){
        if(observacao == null || observacao.trim().isEmpty()){
            System.out.println("Observação Inválida");
        } else {
            this.observacao = observacao;
        }
    }

    @Override
    public String toString(){
        return  "\n===Consulta===" + 
                "\nMédico Responsável: " + medico.getNomeMedico() + 
                "\nPaciente Atendido: " + paciente.getNomePaciente();
    }
}
