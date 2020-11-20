package Assignment8;

import java.util.Arrays;
import java.util.Random;

//Give a very large array of integers, find the maximum value within the array using multithreading.
public class FindMaxInArr {

    public static int findMax(int[] arr){
        final int[] max1 = {Integer.MIN_VALUE};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                max1[0] = one(arr);
            }
        });

        final int[] max2 = {Integer.MIN_VALUE};
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                max2[0] = two(arr);
            }
        });

        final int[] max3 = {Integer.MIN_VALUE};
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                max3[0] = three(arr);
            }
        });

        final int[] max4 = {Integer.MIN_VALUE};
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                max4[0] = four(arr);
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

        int maxA = Math.max(max1[0],max2[0]);
        int maxB = Math.max(max3[0],max4[0]);

        return Math.max(maxA,maxB);
    }

    public static int one(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length/4;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int two(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=arr.length/4;i<arr.length/2;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int three(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=arr.length/2;i<3*(arr.length/4);i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int four(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=3*(arr.length/4);i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    static Random random = new Random();
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        generateRandomArray(arr);

        System.out.println(Arrays.toString(arr));

        int max = Integer.MIN_VALUE;
        try {
            max = findMax(arr);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Max: " + max);
    }
}
