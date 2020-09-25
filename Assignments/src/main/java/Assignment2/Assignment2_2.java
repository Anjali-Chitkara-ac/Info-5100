package Assignment2;

/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++) {
            sum = Math.max(nums[i],sum + nums[i]);
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Assignment2_2 obj = new Assignment2_2();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = obj.maxSubArray(nums);
        System.out.println(maxSum);
    }
}
