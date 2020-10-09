package Assignment4;

import java.util.*;

public class KthLargestElement {

    public int getKthLargest(int[]nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int a = obj.getKthLargest(nums,4);
        System.out.println(a);
    }
}
