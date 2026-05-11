package poo_ex16;

public class Main {

    public static void main(String[] args) {

        // Criando paciente
        Paciente p1 = new Paciente(1, "João Silva", 30, "12345678911");
        
        // Criando médico
        Medico m1 = new Medico(1, "Dra. Ana", "Cardiologia", "CRM-RS 123.456");

        // Criando consulta
        Consulta consulta1 = new Consulta("Paciente Relatou Enjoo e Vômitos", p1, m1);

        // Exibindo resumo da consulta
        System.out.println(consulta1);
        // Saída
        /* 
        ===Consulta===
        Médico Responsável: Dra. Ana
        Paciente Atendido: João Silva
        */

    }
}