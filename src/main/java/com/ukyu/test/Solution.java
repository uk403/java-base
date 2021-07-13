package com.ukyu.test;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author ukyu
 * @time 2021/6/24 23:47
 */
@Slf4j
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    static HashMap<List<Integer>, Boolean> contains = new HashMap<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new LinkedList<>());
        return res;
    }

    private static void dfs(int[] nums, boolean[] used, LinkedList<Integer> list){
        if(list.size() == nums.length)
        {
            if(contains.putIfAbsent(list, Boolean.TRUE) == null)
            {
                log.info(String.valueOf(list));
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i])
            {
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, used, list);
                list.removeLast();
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);
    }
}