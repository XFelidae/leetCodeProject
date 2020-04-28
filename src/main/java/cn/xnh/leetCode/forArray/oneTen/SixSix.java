package cn.xnh.leetCode.forArray.oneTen;

/**
 * @author : xn-h
 * @date: 2020-03-07  20:16
 * @description: 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 */
public class SixSix {

    /**
     * {1,2,3}
     *
     * {1,2,9}
     */
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length -1 ; i >=0 ; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        int nums[] = {9,8,9};
        int result[] = plusOne(nums);
        System.out.println(result);
    }
}
