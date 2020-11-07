package Assignment7;

public class ReverseHello extends Thread {

    int count = 51;

    Object lock = new Object();

    public synchronized void createNPrint(){
        //create a new thread & print
        while (count>1) {
            synchronized (lock) {
                count--;
                Thread thread1 = new Thread(() -> System.out.println("hello from thread " + count));
                thread1.start();
                try{
                    //t.sleep(100);
                    thread1.join();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        ReverseHello obj = new ReverseHello();

        obj.createNPrint();
    }



}
