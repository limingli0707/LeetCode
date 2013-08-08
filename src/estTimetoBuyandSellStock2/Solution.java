package estTimetoBuyandSellStock2;
//题意：买卖股票的第二题。与1的变化在于可以买卖任意次数，但必须保证买卖一次后才能进行第二次。
//分析：实际上是求波浪线的所有上升段的长度和。
public class Solution {
	public int maxProfit(int[] prices){
	 int result = 0;
     int i = 0;
     int len = prices.length;
     if(len<2)
         return 0;
     for(i=1;i<len;++i)
     {
         if(prices[i]>prices[i-1])
         {
             result += prices[i]-prices[i-1];
         }
     }
     return result;
	}

}
