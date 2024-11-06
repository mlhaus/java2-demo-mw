package edu.kirkwood.threads;

public class SumArray {
    private int sum;

    // Add the word synchronized between public and int
    public int sumArray(int[] nums) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumArray().sumArray(new int[]{8, 1, 9, 2, 6, 7}));
    }
}
