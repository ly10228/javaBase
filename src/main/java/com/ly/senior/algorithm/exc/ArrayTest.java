package com.ly.senior.algorithm.exc;

import org.junit.Test;

import java.util.*;

/**
 * @author luoyong
 *  * @create 2020-12-03 4:10 下午
 *  * @last modify by [luoyong 2020-12-03 4:10 下午]
 * @Description: 简单算法
 **/
public class ArrayTest {
    /**
     * @param nums   数组
     * @param target 目标值
     * @return int[]
     * @Description: 计算两数之和 给定 nums = [2, 7, 11, 15], target = 9 LeetCode-1
     * @author luoyong
     * @create 4:11 下午 2020/12/3
     * @last modify by [LuoYong 4:11 下午 2020/12/3 ]
     */
    public int[] twoSum(int[] nums, int target) {
        //key:数组下标对应的值 value:数组下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                continue;
            }
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * @return void
     * @Description: 计算两数之和 测试
     * @author luoyong
     * @create 4:16 下午 2020/12/3
     * @last modify by [LuoYong 4:16 下午 2020/12/3 ]
     */
    @Test
    public void testTwoSum() {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] resultIndex = twoSum(nums, target);
        System.out.println(Arrays.toString(resultIndex));
    }


    public int removeDuplicates1(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int count = 0;

        //key 数值 value：数值对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                nums[count] = nums[i];
                count++;

            }
        }

        return count;
    }


    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        //一次循环 双指针
        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            //相邻两个数值比较
            if (nums[start] != nums[end]) {
                //相邻两个数值不相等 前移做比较
                start++;
                nums[start] = nums[end];

            }
        }
        return start + 1;
    }

    @Test
    public void testRemoveDuplicates() {
        List list = new ArrayList();
        int[] nums = {1, 2, 2, 3, 3, 4, 5};
        System.out.println(removeDuplicates1(nums));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test() {
//        System.out.println(System.currentTimeMillis() / 60000);
        System.out.println(5000 - System.currentTimeMillis() % 1000);
        System.out.println(12 / 11);
    }
}
