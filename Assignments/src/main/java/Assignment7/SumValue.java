package Assignment7;

import java.util.Arrays;
import java.util.Random;

public class SumValue {

    static Random random = new Random();
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        final long[] sum1 = {0};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //sum of 1st 1mil
                sum1[0] = one(arr);
            }
        });

        final long[] sum2 = {0};
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //sum of 2nd 1 mil
                sum2[0] = two(arr);
            }
        });

        final long[] sum3 = {0};
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //sum of 3rd 1mil
                sum3[0] = three(arr);
            }
        });

        final long[] sum4 = {0};
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                //sum of 4th 1 mil
                sum4[0] = four(arr);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        long result = sum1[0] + sum2[0] + sum3[0] + sum4[0];

        return result;
    }

    public static long one(int[] arr){
        long sum = 0;
        for(int i=0;i<arr.length/4;i++){
            sum += arr[i];
        }
        return sum;
    }

    public static long two(int[] arr){
        long sum = 0;
        for(int i=arr.length/4;i<arr.length/2;i++){
            sum += arr[i];
        }
        return sum;
    }

    public static long three(int[] arr){
        long sum = 0;
        for(int i=arr.length/2;i<3*(arr.length/4);i++){
            sum += arr[i];
        }
        return sum;
    }

    public static long four(int[] arr){
        long sum = 0;
        for(int i=3*(arr.length/4);i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[4000000];
        generateRandomArray(arr);

        //System.out.println(Arrays.toString(arr));

        long sum = 0;
        try {
            sum = sum(arr);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Sum: " + sum);
    }
}
