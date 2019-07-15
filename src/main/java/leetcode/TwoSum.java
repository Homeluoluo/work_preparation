package leetcode;/*
* 1.Two Sum
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
* Example:
* Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

//    Solution1 1: Brute-Force Algorithm
//
//    Time complexity : O(n^2)
//    Space complexity : O(1)
    public int[] twoSum1(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }

    //Solution1 2: Using Hash-table
    //
    //Time complexity : O(n) - Array containing n elements is traversed only once. Each look up in the hash-table takes a constant time.
    //Space complexity : O(n) - The extra space required depends on the number of items stored in the hash table, which can be at most n elements.
    public int[] twoSum2(int[] nums, int target) {
        if(nums.length<=1){
            return null;
        }else{
            Map<Integer, Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    return new int[]{map.get(nums[i]), i};
                }else{
                    map.put(target-nums[i],i);
                }
            }
        }
        return null;
    }

//    Solution1 3: Sorting Approach
//
//    Time complexity : O(n.log n) - Time required for sorting an Array
//    Space complexity : O(n) - space for an additional array
    public int[]twoSum3(int[] nums, int target){
        int[] B = Arrays.copyOf(nums, nums.length);
        Arrays.sort(B);

        int start = 0;
        int end = nums.length - 1;

        while(start < end)
        {
            if(B[start] + B[end] == target)
            {
                int i = 0;
                int j = nums.length - 1;

                while(i < nums.length && nums[i] != B[start])
                    i++;
                while(j >= 0 && nums[j] != B[end])
                    j--;

                return new int[]{i, j};
            }
            else if(B[start] + B[end] < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return new int[2];
    }
}
