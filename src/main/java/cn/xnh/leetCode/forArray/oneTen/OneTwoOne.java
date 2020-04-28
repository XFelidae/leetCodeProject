package cn.xnh.leetCode.forArray.oneTen;

/**
 * @author : xn-h
 * @date: 2020-03-08  10:04
 * @description: 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 */
public class OneTwoOne {


    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length ==1){
            return 0;
        }

        int minNum = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            minNum = Math.min(minNum,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - minNum);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int nums[] = {7,6,4,3,1,8};
        System.out.println(maxProfit(nums));
    }
}
