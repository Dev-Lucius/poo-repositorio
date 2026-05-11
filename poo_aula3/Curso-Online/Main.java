package poo_aula3;

public class Main{
    public static void main(String[] args){

        Curso poo = new Curso("POO IFRS", 99.9f);
        poo.setSlogan("Do básico ao Avançado com 9 Projetos");

        poo.addAula(new Aula("Introdução Abstração", 3.0));
        poo.addAula(new Aula("Getters, Setters & Construtores", 3.0));
        
        poo.aula03 = new Aula("03", 1);
        poo.addAula(aula03);

        System.out.println(poo.getTotalAulas()); // 3
        System.out.println(poo.getTotalCH()); // 6

        poo.removerAula(aula03);
        System.out.println(poo.getTotalAulas()); // 2
        System.out.println(poo.getTotalCH()); // 5

        System.out.println(poo); // Título Mais Slogan
        poo.setSlogan("outro slogan");

        poo.setTitulo("ab"); // não pode ter menos que 7
        System.out.println(poo); // titulo + slogan
    }
}