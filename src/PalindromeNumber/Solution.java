package PalindromeNumber;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
class Solution {
	
	    public boolean isPalindrome(int x) {
	         // Start typing your C/C++ solution below
	         // DO NOT write int main() function
	         if (x < 0)
	             return false;
	         if (x == 0)
	             return true;
	             
	         int base = 1;
	         while(x / base >= 10)
	             base *= 10;
	             
	         while(x!=0)
	         {
	             int leftDigit = x / base;
	             int rightDigit = x % 10;
	             if (leftDigit != rightDigit)
	                 return false;
	             
	             x -= base * leftDigit; //ȥ�����λ
	             base /= 100; //��Ϊÿ��ȥ�����λ�����λ �����ܹ�ȥ��2λ 
	             x /= 10;//ȡ����λ
	         }
	         
	         return true;
	     }
	 };