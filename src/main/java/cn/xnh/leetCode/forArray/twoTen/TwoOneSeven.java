package cn.xnh.leetCode.forArray.twoTen;

import java.util.*;

/**
 * @author : xn-h
 * @date: 2020-03-08  19:48
 * @description: 217. 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class TwoOneSeven {

    /**
     * 使用SET来保存判断是否存在重复数
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> tempSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(tempSet.contains(nums[i])){
                return true;
            }
            tempSet.add(nums[i]);
        }
        return false;
    }

    /**
     * 利用数组排序后，遍历数组
     */
    public static boolean containsDuplicate1(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(containsDuplicate1(nums));
    }
}
