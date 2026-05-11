package Atv02;

public class ThreadMensagens implements Runnable {

    @Override
    public void run() {

        for(int i = 1; i <= 5; i++) {

            System.out.println("Mensagem da Thread: Executando tarefa...");

            try {
                Thread.sleep(2000); // 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}