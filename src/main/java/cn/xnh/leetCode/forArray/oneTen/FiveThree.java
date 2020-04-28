package cn.xnh.leetCode.forArray.oneTen;

/**
 * @author : xn-h
 * @date: 2020-03-07  19:46
 * @description: 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class FiveThree {

    /**
     * 贪心算法
     *
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            /**
             * {-1,2,3,-2,-5,4,-5}
             * 初始值 currSum: -1  maxSum :-1
             * currSum : 2  maxSum: 2
             * currSum : 5  maxSum: 5
             * currSum : 3  maxSum: 5
             * currSum : 8  maxSum: 8
             * currSum : 12 maxSum: 12
             * currSum : 7  maxSum: 12
             */
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            System.out.println("currSum:"+currSum+",maxSum:"+maxSum);
        }
        return maxSum;
    }

    /**
     *
     */
    public static int maxSubArray1(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            System.out.println("maxSum:"+maxSum + ";num"+i+":"+nums[i]);
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,-2,5,-4,-5};
        System.out.println(maxSubArray(nums));
    }
}
