package com.sangbill.leecode.view;

class T0121_maxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            res = Math.max(res,prices[i] - min);
        }
        return res;
    }
}