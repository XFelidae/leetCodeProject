package cn.xnh.leetCode.forArray.twoTen;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : xn-h
 * @date: 2020-03-08  10:33
 * @description: 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 */
public class OneSixSeven {

    /**
     * 使用map存储值来判断
     */
    public static int[] twoSum(int[] numbers, int target) {

        Map<Integer,Integer> tempMap = new HashMap<>();
        int first = numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] < target || (first+numbers[i]) <= target){
                if(tempMap.containsKey(target-numbers[i])){
                    return new int[]{tempMap.get(target-numbers[i])+1,i+1};
                }
                tempMap.put(numbers[i],i);
            }else {
                break;
            }
        }
        return null;
    }

    /**
     * 可以使用双指针，判断头尾相加，大了，尾部往前移，小了，头部往后移
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -1;
        while (i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1,j+1};
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int result[] = twoSum1(nums,9);
        System.out.println(result);
    }
}
