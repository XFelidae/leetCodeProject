package cn.xnh.leetCode.forArray.oneTen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xn-h
 * @date: 2020-03-07  23:44
 * @description: 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class OneOneNine {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList();
        list.add(1);
        int n = 1;
        while(n <= rowIndex){
            //提交补充数组最后一位，防止越界
            //杨辉三角，每一行比前一行多处一列
            list.add(0);
            //从尾部往前处理，防止数据污染
            for(int i = list.size() - 1; i > 0; i--){
                list.set(i,list.get(i) + list.get(i - 1));
            }
            n++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = getRow(5);
        System.out.println(result);
    }
}
