package at.spengergasse._2xhif.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking_Lock {

    private Lock lock;
    private int idx;

    static void main() {
        Locking_Lock locking = new Locking_Lock();
        locking.execute();
    }

    public void execute() {
        lock = new ReentrantLock();

        Thread t1 = new Thread(new Counter(1, this, lock));
        Thread t2 = new Thread(new Counter(2, this, lock));
        Thread t3 = new Thread(new Counter(3, this, lock));

        t1.start();
        t2.start();
        t3.start();
    }

    private class Counter implements Runnable {

        private int number;
        private Lock lock;
        private Locking_Lock parent;

        public Counter(int number, Locking_Lock parent, Lock lock) {
            this.number = number;
            this.parent = parent;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (parent.idx < 67) {
                // Using locks requires us to call tryLock to attempt to secure our lock
                // if this fails, because some other thread already secured the lock, this returns false
                // in this case we wait for a short time and try again
                while (!lock.tryLock()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // handle
                    }
                }

                parent.idx++;
                System.out.println("Thread " + number + " incremented to " + parent.idx);

                // here, it is important to manually unlock once we are done with our resource
                lock.unlock();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
