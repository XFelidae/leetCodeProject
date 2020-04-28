package cn.xnh.leetCode.forArray.twoTen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : xn-h
 * @date: 2020-03-08  11:04
 * @description: 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class OneSixNine {

    public static int majorityElement(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }


        int num = nums.length/2;

        Map<Integer,Integer> tempMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int count = 1;
            if(tempMap.containsKey(nums[i])){
                count = tempMap.get(nums[i]) + 1;
                tempMap.put(nums[i],count);
            }else {
                tempMap.put(nums[i],count);
            }
            if(count > num){
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 排序法
     * 将数组排好序，那么n/2位置就是该值
     * 时间复杂度：O(nlgn)
     */
    public  static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 投票法
     * 计数，当下一个数与前面一个数一致加1，不一致减1
     * 为0时，重置
     */
    public static int majorityElement2(int[] nums){
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if(count == 0){
                result = num;
            }
            if(num == result){
                count ++;
            }else {
                count --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums));
    }
}
