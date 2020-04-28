package cn.xnh.leetCode.forArray.twoTen;

/**
 * @author : xn-h
 * @date: 2020-03-08  10:17
 * @description: 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class OneTwoTwo {

    /**
     * 贪心算法
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        System.out.println(maxProfit(nums));
    }
}
