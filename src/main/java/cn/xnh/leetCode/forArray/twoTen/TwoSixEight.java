package cn.xnh.leetCode.forArray.twoTen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : xn-h
 * @date: 2020-03-08  20:29
 * @description: 268. 缺失数字
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class TwoSixEight {

    /**
     * 相当于排序后 遍历
     */
    public static int missingNumber(int[] nums) {
        int temp[] = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            temp[nums[i]] = nums[i];
        }
        for(int i=0;i<temp.length;i++){
            if(i != temp[i]){
                return i;
            }
        }
        return 0;
    }



    public static int missingNumber1(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    /**
     * 使用异或
     * 对一个数进行两次完全相同的异或运算会得到原来的数
     */
    public static int missingNumber2(int[] nums) {

        int missing = nums.length;
        for(int i=0;i<nums.length;i++){
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }


    /**
     * 数学
     * 求出 [0..n]的和，减去数组中所有数的和，就得到了缺失的数字
     * n(n+1)/2
     *
     */
    public static int missingNumber3(int[] nums) {
        int result = nums.length * (nums.length + 1) /2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return result - actualSum;

    }

    /**
     *  排序后 遍历
     */
    public static int missingNumber4(int[] nums) {
        Arrays.sort(nums);
        // 判断 n 是否出现在末位
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(i != nums[i]){
                return i;
            }
        }

        // 未缺失任何数字（保证函数有返回值）
        return -1;

    }

    public static void main(String[] args) {
        int nums[] = {4,1,2,3};
        System.out.println(missingNumber4(nums));
    }
}
