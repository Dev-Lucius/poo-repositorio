package poo_ex8;

public class Main {
    public static void main(String[] args) {
        Departamento dep = new Departamento(1, "Administrativo");

        Funcionario f1 = new Funcionario(1, "Lucas", 2500.00, "Auxiliar Administrativo");
        Funcionario f2 = new Funcionario(2, "João", 3000.00, "Adm Jr");
        Funcionario f3 = new Funcionario(3, "Maria", 3500.00,"Adm Pleno");

        dep.adicionarFuncionario(f1);
        dep.adicionarFuncionario(f2);
        dep.adicionarFuncionario(f3);

        dep.acessarDepartamento();

        System.out.println(dep);
        
        System.out.println("");

        System.out.println(f1); 
        
    }
}
