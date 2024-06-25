package synchronize;
/*
Object-Level Locking Demonstration:
-> The use of synchronized blocks (synchronized (this) { ... }) in the increment() and get()
    methods ensures that modifications (increment()) and retrievals (get()) of the count variable are synchronized per instance (obj1 and obj2).
-> Each instance of SyncBlocks (obj1 and obj2) manages its own lock (this), providing thread
    safety at the object level.
-> his ensures that even though t1 and t2 operate on separate instances (obj1 and obj2), their
    concurrent execution does not lead to data corruption or inconsistent results due to synchronized access.
-> In summary, the SyncBlocks class effectively demonstrates object-level locking in Java
    through the use of synchronized blocks synchronized on this.
    This approach ensures that each instance of the class manages its own synchronization context,
     allowing multiple threads to safely access and modify instance variables without interference
     from other instances
 */
public class objectLevelLock {

    private int count = 0;

    public void increment(){
        synchronized (this){
            count++;
        }
    }

    public int get(){
        synchronized (this){
            return count;
        }
    }

    public static void main(String[] args) {
        objectLevelLock obj1 = new objectLevelLock();
        objectLevelLock obj2 = new objectLevelLock();

        Thread t1 = new Thread(()->{
            for(int i=0; i<10; i++){
                obj1.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0; i<10; i++){
                int value = obj2.get();
                System.out.println(value);
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
