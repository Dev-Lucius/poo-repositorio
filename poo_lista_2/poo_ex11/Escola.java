package poo_ex11;

public class Escola {

    Aluno aluno; // Associação
    private String identificacao;

    public Escola(String identificacao){
        this.identificacao = identificacao;
    }

    public void atualizarNota(Aluno aluno, double novaNota){
        if(aluno == null){
            System.out.println("Aluno Não Encontrado");
        } else {
            System.out.println("\n[" + identificacao + "] Iniciando Atualização");
            aluno.setNota(novaNota);
            System.out.println("\n[" + identificacao + "] Atualização Concluída");
        }
    }
}
