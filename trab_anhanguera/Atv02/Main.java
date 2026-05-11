package Atv02;

public class Main {

    public static void main(String[] args) {

        ThreadNumeros tarefa1 = new ThreadNumeros();
        ThreadMensagens tarefa2 = new ThreadMensagens();

        Thread thread1 = new Thread(tarefa1);
        Thread thread2 = new Thread(tarefa2);

        thread1.start();
        thread2.start();

    }

}