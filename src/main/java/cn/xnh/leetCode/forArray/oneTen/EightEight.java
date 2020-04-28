package cn.xnh.leetCode.forArray.oneTen;

import java.util.Arrays;

/**
 * @author : xn-h
 * @date: 2020-03-07  20:31
 * @description: 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 */
public class EightEight {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    /**
     *   双指针
     *   从双数组尾部开始遍历
     *   因为最终结果保存在数组1中，判断数组2最后一个值是否比数组1最后一个值大
     *   比较大，则把数组2最后一个值放到最后一位(因为是有序数组，最后一位比较即可判断是否为最大值)，数组2指针往前，重复判断
     *   比较小，则把数组1最后一个值放到最后一位，数组1指针往前，重复
     *   当数组2，先遍历完，则数据排序成功
     *   当数组1，先遍历完，说明数组2剩余数据都小于数据1的值，将数据2剩余值，复制到数组1中(从0开始)即可
     *   System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            // nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            if (nums1[p1] < nums2[p2]) {
//                nums1[p--] = nums2[p2--];
                nums1[p] = nums2[p2];
                p2--;
            } else {
//                nums1[p--] = nums1[p1--];
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

    public static void main(String[] args) {
        int nums1[] = {2,3,5,8,0,0,0,0};
        int nums2[] = {1,3,4,7};
        int p = 3;
        System.out.println(nums1[p--]);
        System.out.println(p);
        merge1(nums1,4,nums2,nums2.length);
        System.out.println(nums1);
    }
}
