public class Main{
    public static void main(String[] args){
        Pessoa p = new Pessoa("Lucas", 21);

        System.out.println(p.getNome()); // Lucas
        System.out.println(p.getIdade()); // 21

        p.setIdade(22);
        System.out.println(p.getIdade()); // 22
    }
}