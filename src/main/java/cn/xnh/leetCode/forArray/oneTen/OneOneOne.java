package cn.xnh.leetCode.forArray.oneTen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xn-h
 * @date: 2020-03-07  21:18
 * @description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class OneOneOne {

    /**
     * 杨辉三角 相当于二维数组
     * 1
     * 11
     * 121
     * 1331
     * 14641
     *
     * 第一列永远为1
     * 从第二列起第一个数永远为1，最后一个数永远为1
     * 从第二数开始遍历，到倒数第一个前结束，中间的数据是等于上一个数组索引-1 + 索引的和
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            //获取上一组数组数据
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            //中间部分等于 上个数组 索引-1 和当前索引的和
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;



    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = generate(5);
        System.out.println(resultList);
    }
}
