package cn.xnh.leetCode.oneToTen;

import java.util.HashMap;

/**
 * @author : xn-h
 * @date: 2019-08-29  09:47
 * @description: 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class TwoSum {

    /**
     * @param nums   整数数组
     * @param target 目标值
     * @author : xn-h
     * @date: 2019-08-29  09:49
     * @description: 从整数数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {

        /**
         * 利用 hashMap 存在  目标值 减去 当前值 即可
         */
        if (nums.length < 2) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            // 判断map 是否保存 目标值减去当前值
            if (map.containsKey(otherNum)) {
                return new int[]{i, map.get(otherNum)};
            }
            //将当前值为key  下标为value 存起来
            map.put(nums[i], i);
        }
        return null;
    }
}
