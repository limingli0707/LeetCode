package estTimetoBuyandSellStock2;
//���⣺������Ʊ�ĵڶ��⡣��1�ı仯���ڿ���������������������뱣֤����һ�κ���ܽ��еڶ��Ρ�
//������ʵ�����������ߵ����������εĳ��Ⱥ͡�
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
