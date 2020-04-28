package cn.xnh.leetCode.forArray.threeTen;

import java.util.*;

/**
 * @author : xn-h
 * @date: 2020-03-09  20:12
 * @description: 532. 数组中的K-diff数对
 *
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 */
public class FiveThreeTwo {

    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        if(k<0)return count;
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        for(int i:map.keySet()){
            if(k==0){
                if(map.get(i)>1)
                    count++;
            }
            else if(map.containsKey(i+k)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        System.out.println(findPairs(nums,3));
    }

}
