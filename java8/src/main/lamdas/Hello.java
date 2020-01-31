package main.lamdas;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello");
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("thread "+ Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(() -> System.out.println("india"));
        t1.start();
        t2.start();
        ICall iCall = () -> {
            System.out.println("icall method ");
        };

        iCall.call();

    }
}
