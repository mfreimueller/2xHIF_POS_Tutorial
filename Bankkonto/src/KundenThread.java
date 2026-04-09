import java.util.Random;

public class KundenThread extends Thread {

    private Konto konto;
    private Random random = new Random();

    public KundenThread(Konto konto) {
        this.konto = konto;
    }

    @Override
    public void run() {
        // here comes the concurrent code
        while (true) {
            final int amount = 100; //random.nextInt(100);

            try {
                // synchronized (konto) {
                    konto.abheben(amount);
                // }
            } catch (RuntimeException e) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }

        System.out.println("Thread " + threadId() + " is done.");
    }

}
