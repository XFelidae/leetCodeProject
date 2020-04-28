package cn.xnh.leetCode.forArray.twoTen;

/**
 * @author : xn-h
 * @date: 2020-03-08  21:01
 * @description: 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class TwoEightThree {

    public static void moveZeroes(int[] nums) {
        int count = 0;
        int i = 0;
        while(i< nums.length){
            if(i + count == nums.length-1){
                break;
            }
            if(nums[i] == 0){
                for(int j=i;j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[nums.length-1-count] = 0;
                count ++;
                i = 0;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1} ;
        moveZeroes(nums);
        System.out.println(nums);
    }
}
