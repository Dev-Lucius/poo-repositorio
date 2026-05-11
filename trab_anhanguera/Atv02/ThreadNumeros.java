package Atv02;

public class ThreadNumeros implements Runnable {

    @Override
    public void run() {

        for(int i = 1; i <= 10; i++) {

            System.out.println("Número: " + i);

            try {
                Thread.sleep(1000); // 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}