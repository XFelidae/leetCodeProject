package cn.xnh.leetCode.forArray.twoTen;

import java.util.*;

/**
 * @author : xn-h
 * @date: 2020-03-08  20:02
 * @description: 219. 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 */
public class TwoOneNine {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> tempMap = new HashMap<>();
        List<Integer> indexList = null;
        for(int i=0;i<nums.length;i++){
            if(tempMap.containsKey(nums[i])){
                indexList = tempMap.get(nums[i]);
                for (Integer integer : indexList) {
                    if((i - integer) <= k){
                        return true;
                    }
                }

            }else{
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            tempMap.put(nums[i],indexList);
        }
        return false;
    }

    /**
     * 在散列表中搜索当前元素，如果找到了就返回 true。
     * 在散列表中插入当前元素。
     * 如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate1(nums, 2));
    }
}
