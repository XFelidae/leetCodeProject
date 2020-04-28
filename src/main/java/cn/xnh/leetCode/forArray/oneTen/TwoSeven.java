package cn.xnh.leetCode.forArray.oneTen;

/**
 * @author : xn-h
 * @date: 2020-03-07  17:45
 * @description: 27. 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class TwoSeven {

    /**
     * 利用双指针判断
     * 当j位置等于当前值，数组往后移
     * 当j位置不等于当前值，即将j位置的数据赋值到i位置上，i往后移
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0 ){
            return 0;
        }
        int i = 0;
        for(int j = 0; j<nums.length;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 利用头尾双指针
     * 当头指针等于当前值时，将尾指针的数据赋值到头指针的位置，尾指针-1
     * 否则，头指针继续往后移
     */
    public static int removeElement1(int[] nums, int val){
        if (nums.length == 0 ){
            return 0;
        }
        int i = 0;
        int n = nums.length;
        while (i<n){
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int nums[] = {1,6,3,2,3,4,3,1};
        System.out.println(removeElement(nums,3));
        System.out.println(nums);
    }
}
