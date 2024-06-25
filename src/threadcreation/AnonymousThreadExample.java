package threadcreation;

public class AnonymousThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable world!!");
            }

        });

        t1.start();
    }
}
