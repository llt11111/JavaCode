package main.locks;


import java.util.concurrent.Semaphore;

public class PrintEvenOddSemaphore {
    Semaphore even = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
     void printEven(int i) throws InterruptedException {

            even.acquire();
            System.out.println(i);
            odd.release();
    }
     void printOdd(int i) throws InterruptedException {
            odd.acquire();
            System.out.println(i);
            even.release();
    }

    public static void main(String[] args) {
        PrintEvenOddSemaphore printer = new PrintEvenOddSemaphore();
        Thread even = new Thread(() -> {
            for (int i = 0 ; i<14; i++){
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
        Thread odd = new Thread(() -> {
            for (int i = 1 ; i<14; i++){
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
