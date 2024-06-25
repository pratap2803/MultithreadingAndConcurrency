package threadcreation;

public class Lambda {
    public static void main(String[] args) {
        // creating thread using lambda expression
        Thread t1 = new Thread(() -> { // implicitly we are using Runnable interface
            System.out.println("Hello from lambda expression!!");
        });
        t1.start();
    }
}
