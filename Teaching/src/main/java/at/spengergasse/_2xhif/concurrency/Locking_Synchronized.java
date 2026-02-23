package at.spengergasse._2xhif.concurrency;

public class Locking_Synchronized {

    private int idx;

    static void main() {
        Locking_Synchronized locking = new Locking_Synchronized();
        locking.execute();
    }

    public void execute() {
        Thread t1 = new Thread(new Counter(1, this));
        Thread t2 = new Thread(new Counter(2, this));
        Thread t3 = new Thread(new Counter(3, this));

        t1.start();
        t2.start();
        t3.start();
    }

    private class Counter implements Runnable {

        private int number;
        private Locking_Synchronized parent;

        public Counter(int number, Locking_Synchronized parent) {
            this.number = number;
            this.parent = parent;
        }

        @Override
        public void run() {
            while (parent.idx < 67) {
                // using synchronized, in this case using the parent as our "lock", we don't need to worry
                // about locking or unlocking
                synchronized (parent) {
                    parent.idx++;
                    System.out.println("Thread " + number + " incremented to " + parent.idx);
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
