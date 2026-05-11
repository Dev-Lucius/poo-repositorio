package poo_ex8;

public class Funcionario {

    private int id;
    private String nome;
    private double salario;
    private String cargo;

    private Departamento departamento;

    public int getIdFuncionario() {
        return id;
    }
    public String getNomeFuncionario() {
        return nome;
    }
    public double getSalarioFuncionario() {
        return salario;
    }
    public String getCargoFuncionario() {
        return cargo;
    }
    
    public Departamento getDepartamentoFuncionario(){
        return departamento;
    }

    public void setIdFuncionario(int id){
        if(id <= 0){
            throw new IllegalArgumentException("ID Inválido");
        } else {
            this.id = id;
        }
    }

    public void setNomeFuncionario(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setSalarioFuncionario(double salario){
        if(salario <= 0){
            throw new IllegalArgumentException("Salário Inválido");
        } else {
            this.salario = salario;
        }
    }

    public void setCargoFuncionario(String cargo){
        if(cargo == null || cargo.trim().isEmpty()){
            throw new IllegalArgumentException("Cargo Inválido");
        } else {
            this.cargo = cargo;
        }
    }

    public void setDepartamentoFuncionario(Departamento departamento){
        this.departamento = departamento;
    }

    /**
     * 
     * @param id Identificador
     * @param nome Nome
     * @param salario Salario
     * @param cargo Cargo
     * Departamento começa null - será definido via um setter
     */
    public Funcionario(int id, String nome, double salario, String cargo){
        setIdFuncionario(id);
        setNomeFuncionario(nome);
        setSalarioFuncionario(salario);
        setCargoFuncionario(cargo);
    }

    
    @Override
    public String toString(){
        return  "Funcionário #" + id + 
                " | Nome: " + nome + 
                " | Cargo: " + cargo + 
                " | Salário: R$ " + String.format("%.2f", salario) + 
                " | Depto: " + (departamento != null ? departamento : "Sem Departamento");
    }
}
