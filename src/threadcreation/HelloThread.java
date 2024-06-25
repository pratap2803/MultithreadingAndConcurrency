package threadcreation;
/*
Problem: Write a program that creates a thread to print "Hello from the thread!" to the console.
 */
public class HelloThread  extends Thread {
    @Override
    public void run(){
        System.out.println("Hello world!!");
    }

    public static void main(String[] args) {
        HelloThread t1 = new HelloThread();
        t1.start();
    }
}
