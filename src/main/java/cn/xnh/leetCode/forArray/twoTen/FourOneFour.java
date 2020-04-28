package cn.xnh.leetCode.forArray.twoTen;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author : xn-h
 * @date: 2020-03-08  21:40
 * @description: 414. 第三大的数
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
public class FourOneFour {

    /**
     * 利用三个标识位处理
     */
    public static int thirdMax(int[] nums) {

        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int flag = 0;

        boolean f=true;

        for(int i=0;i<nums.length;i++){
            /**
             * 表示 当遇到最小值时，且还未赋值到max1,max2,max3时，做的标识位
             */
            if(nums[i]==Integer.MIN_VALUE && f){
                flag++;
                f=false;
            }

            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                flag++;
            }else if(nums[i] < max1 && nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
                flag++;
            }else if(nums[i] < max2 && nums[i] > max3){
                max3 = nums[i];
                flag++;
            }
        }

        if(flag <3){
            return max1;
        }
        return max3;

    }

    public static void main(String[] args) {
        int nums[] = {1,-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        System.out.println(thirdMax(nums));
    }
}
