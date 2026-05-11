package poo_ex16;

public class Medico {

    private int id;
    private String nome;
    private String especialidade;
    private String crm;
    

    public int getId() {
        return id;
    }


    public String getNomeMedico() {
        return nome;
    }


    public String getEspecialidade() {
        return especialidade;
    }


    public String getCrm() {
        return crm;
    }


    public Medico(int id, String nome, String especialidade, String crm){
        setId(id);
        setNome(nome);
        setEspecialidade(especialidade);
        setCrm(crm);
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("ID inválido");
        } else {
            this.id = id;
        }
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setEspecialidade(String especialidade){
        if(especialidade == null || especialidade.trim().isEmpty()){
            System.out.println("Especialidade Inválida");
        } else {
            this.especialidade = especialidade;
        }
    }

    public void setCrm(String crm){
        if(crm == null || crm.trim().isEmpty()){
            System.out.println("CRM Inválido");
        } else {
            this.crm = crm;
        }
    }

    @Override
    public String toString(){
        return  "\n=== Médico ===" + 
                "\nId: " + id + 
                "\nnNome: " + nome + 
                "\nEspecialidade: " + especialidade + 
                "\nCRM: " + crm;
    }
}
