package edu.kirkwood.threads;

public class UseThreads {
    public static void main(String[] args) throws InterruptedException {
        int[] a = {1, 2, 3, 4, 5};
        MyThread mt1 = MyThread.createAndStart("Child #1", a);
        mt1.thread.setPriority(Thread.MIN_PRIORITY);
        MyThread mt2 = MyThread.createAndStart("Child #2", a);
        mt2.thread.setPriority(Thread.MAX_PRIORITY);
        MyThread mt3 = MyThread.createAndStart("Child #3", a);
        mt3.thread.setPriority(Thread.NORM_PRIORITY);
        mt1.thread.join();
        System.out.println("Child #1 joined");
        mt2.thread.join();
        System.out.println("Child #2 joined");
        mt3.thread.join();
        System.out.println("Child #3 joined");
    }
}
