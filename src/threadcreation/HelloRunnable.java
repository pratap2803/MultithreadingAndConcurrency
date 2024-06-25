package threadcreation;
/*
Problem: Write a program that creates a thread to print "Hello from the thread!" to the console.
 */
public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World!!");
    }

    public static void main(String[] args) {
        HelloRunnable helloRunnableObj = new HelloRunnable();
        Thread t1 = new Thread(helloRunnableObj, "Hello world thread");
        t1.start();
    }
}
