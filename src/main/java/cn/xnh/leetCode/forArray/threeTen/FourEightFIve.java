package cn.xnh.leetCode.forArray.threeTen;

/**
 * @author : xn-h
 * @date: 2020-03-09  18:53
 * @description: 485. 最大连续1的个数
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FourEightFIve {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int max1 = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                max1 ++;
            }else{
                max = Math.max(max,max1);
                max1 = 0;
            }
        }
        max = Math.max(max,max1);
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,0,1,1,1} ;
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
