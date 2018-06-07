package com.ybj.algorithmdemo.arrayone;

import java.util.Arrays;

/**
 * Created by 杨阳洋 on 2018/6/7.
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

   不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 那些需要记录值
 * pre跟current值不相等(一定记录)，current为0可能需要记录值，交换后需要记录值
 *
 * 那些需要交换值
 * isMarkValue != next &&next != 0
 *
 * 那些需要next为0
 * current == next，isMarkValue == nums[j]
 */

public class ArrayOne {
    private int isMarkValue = 0;
    private int lengh;
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int num = nums[nums.length - 1];
        for (int i = 1 ; i < nums.length ; i ++){
            if(nums[i - 1] == nums[i] || nums[i] == 0) {//记录值
                if(nums[i] != 0) {
                    isMarkValue = nums[i];
                }
                for (int j = i + 1 ; j < nums.length ; j ++){
                    if(nums[i] == nums[j] && isMarkValue == nums[j]) {
                        nums[j] = 0;
                        continue;
                    }else{
                        if(nums[j] != 0 && isMarkValue != nums[j]) {
                            if(num == nums[j]) {
                                lengh = i + 1;
                            }
                            nums[i] = nums[j];
                            isMarkValue = nums[j];
                            nums[j] = 0;
                            break;
                        }else{
                            nums[j] = 0;
                            continue;
                        }
                    }
                }
            }else{
                continue;
            }
        }
        nums =  Arrays.copyOf(nums,lengh);
        return lengh;
    }
}
