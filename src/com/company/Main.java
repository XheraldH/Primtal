package com.company;


public class Main {


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Running (0 , 350000));
        thread.setName("First Thread");
        Thread thread1 = new Thread(new Running (350001, 500000));
        thread1.setName("Second Thread");

        thread.join();
        thread1.join();
        thread.start();
        thread1.start();


    }
}

class Running implements Runnable {

    private final int start;
    private final int stop;
    private int pConuter;

    public Running(int start, int stop) {
        this.start = start;
        this.stop = stop;
        this.pConuter = 0;
    }

    @Override
    public void run() {

        for (int i = start; i <= stop; i++) {
            int counter = 0;
            for (int num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                pConuter++;
            }
        }
        System.out.println(Thread.currentThread().getName() + "-Primary num in total in this thread:" + pConuter);

    }
}