package main.locks;


import java.util.concurrent.Semaphore;

public class PrintOneTwoThreeWithSemaphore {
    Semaphore one = new Semaphore(1);
    Semaphore two = new Semaphore(0);
    Semaphore three = new Semaphore(0);
     void printOne(int i) throws InterruptedException {
        one.acquire(1);
        System.out.println(i);
        two.release(2);


    }
     void printTwo(int i) throws InterruptedException{
         two.acquire(2);
         System.out.println(i);
         three.release(3);
    }
    void printThree(int i) throws InterruptedException {
        three.acquire(3);
        System.out.println(i);
        one.release(1);
    }

    public static void main(String[] args) {
        PrintOneTwoThreeWithSemaphore printer = new PrintOneTwoThreeWithSemaphore();
        Thread one = new Thread(() -> {
            for (int i = 0 ; i<3; i++){
                try {
                    printer.printOne(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0 ; i<3; i++){
                try {
                    printer.printTwo(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread three = new Thread(() -> {
            for (int i = 0 ; i<3; i++){
                try {
                    printer.printThree(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        one.start();
        two.start();
        three.start();
    }
}
