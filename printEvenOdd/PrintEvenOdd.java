package main.locks;

class Printer{
    boolean isEvenThread = true;
    void printEven(int i) throws InterruptedException {
        synchronized (this) {
            while (!isEvenThread) {
                wait();
            }
            System.out.println(i);
            isEvenThread = false;
            notifyAll();
        }
    }
    void printOdd(int i) throws InterruptedException {
        synchronized (this) {
            while (isEvenThread) {
                wait();
            }
            System.out.println(i);
            isEvenThread = true;
            notifyAll();
        }
    }
}

public class PrintEvenOdd {
    private static Printer printer = new Printer();


    public static void main(String[] args) {

        Thread even = new Thread(() -> {
           for (int i = 0 ; i<10; i++){
               try {
                   printer.printEven(i);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               i++;
           }
        });
        Thread odd = new Thread(() -> {
            for (int i = 1 ; i<10; i++){
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
        even.start();
        odd.start();
    }

}
