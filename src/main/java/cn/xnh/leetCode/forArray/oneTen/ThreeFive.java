package cn.xnh.leetCode.forArray.oneTen;

/**
 * @author : xn-h
 * @date: 2020-03-07  19:31
 * @description: 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class ThreeFive {

    /**
     * 遍历全部数组，判断等于或大于目标值的位置即可
     */
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i< nums.length;i++){
            if(nums[i] == target || nums[i] > target){
                return i;
            }
        }
        return nums.length;
    }

    /**
     *  利用二分查找方法，找到等于或大于目标值位置
     */
    public static int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //中间位置
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                //右边往中间位置-1
                right = mid - 1;
            } else {
                //左边往中间位置+1
                left = mid + 1;
            }
        }
        //此时left = right
        return target <= nums[left] ? left : left + 1;

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6};
        int target = 4;
        System.out.println(searchInsert1(nums,target));
    }
}
