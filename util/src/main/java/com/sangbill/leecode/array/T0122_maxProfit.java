package com.sangbill.leecode.array;
class T0122_maxProfit {
    public static int maxProfit(int[] prices) {
        if(prices.length <= 1)
                    return 0;

        int times = 2;
        return sdf(prices,0,0,true,times);
    }

    public static int sdf(int[] prices,int i,int buy, boolean findBuy,int times){
        if(buy >= prices.length || times == 0)
            return 0;

        if(findBuy){
            for(; buy < prices.length -1;buy++){
                if(prices[buy] < prices[buy + 1]){
                    break;
                }
            }
            return sdf(prices,buy + 1,buy,false,times);
        }else{
            if(i + 1 < prices.length - 1){
        		return Math.max(
						(prices[i] - prices[buy]) + sdf(prices, i + 1, buy, true, times - 1),
						sdf(prices, i + 1, buy, false, times)           
					);      
            }else{          	
                return Math.max((prices[i] - prices[buy]),0);
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] prices = {1,2,4,2,5,7,2,4,9,0};
		int sum = maxProfit(prices);
		System.out.println(sum);
	}
}