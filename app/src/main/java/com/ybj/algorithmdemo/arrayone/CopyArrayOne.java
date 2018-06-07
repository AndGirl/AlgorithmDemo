package com.ybj.algorithmdemo.arrayone;

import java.util.Arrays;

/**
 * Created by 杨阳洋 on 2018/6/7.
 */

public class CopyArrayOne {

    private int i;
    {
        i = 0;
    }

    public int removeDuplicates(int[] nums){

        if(nums == null || nums.length == 0) {
            return 0;
        }

        for (int j = 1 ; j < nums.length ; j ++){
            if(nums[i] != nums[j]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        nums = Arrays.copyOf(nums,i);
        return i;

    }

}
