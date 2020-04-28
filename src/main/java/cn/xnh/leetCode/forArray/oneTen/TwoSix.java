package cn.xnh.leetCode.forArray.oneTen;

/**
 * @author : xn-h
 * @date: 2020-03-07  17:23
 * @description: 26. 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class TwoSix {

    /**
     * 双指针 i为慢指针   j为快指针
     * 当j位置的数据等于i位置，j指针往后移，
     * 当j与i位置不一致，即可覆盖i+1位置的值
     */
    public static int removeDuplicates(int[] nums) {
        //边界处理
        if(nums.length == 0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,4,5,5,6,7};
        System.out.println(removeDuplicates(nums));
        System.out.println(nums);
    }
}
