package com.sangbill.leecode.stack;

class T0456_find132pattern {
    public boolean find132pattern(int[] nums) {
        int index = 0;
        boolean asc = false;
        int[] start = new int[nums.length];
        int[] end = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if(find132pattern(nums,i,start,end,index)){
                return true;
            }

            if (nums[i] < nums[i + 1]) {  //递增
                if (asc) { //前一个是递增，把递增值增加
                    end[index - 1] = i + 1;
                } else {  //前一个是非递增，另起
                    start[index] = i;
                    end[index] = i + 1;
                    index++;
                }
                asc = true;
            } else if (nums[i] == nums[i + 1]) {
                continue;
            } else { //递减
                asc = false;
            }
        }
        //判断最后一个元素
        return find132pattern(nums,nums.length - 1,start,end,index);
    }

    private boolean find132pattern(int[] nums, int i, int[] start, int[] end, int index) {
        for (int j = 0; j < index; j++) { //判断目标点nums[i]是否落在递增线段中
            if(nums[start[j]] < nums[i] && nums[end[j]] > nums[i]){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        T0456_find132pattern su = new T0456_find132pattern();
        System.out.println(su.find132pattern(new int[]{-2,1,2,-2,1,2}));
    }
}