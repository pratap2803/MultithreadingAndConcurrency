public class SyncCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getValue() {
        return count;
    }

    public static void main(String[] args) {
        // Create an instance of SynchronizedCounter
        SyncCounter counter = new SyncCounter();

        // Create and start multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count value
        System.out.println("Final Count: " + counter.getValue());
    }
}
