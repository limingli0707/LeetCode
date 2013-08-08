package SqrtX;
//¶þ²æËÑË÷
public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long  i=0;
        long j=x/2+1;
        while(i<=j){
        	long mid =(i+j)/2;
        	long sq=mid*mid;
        	if(sq==x) return (int)mid;
        	else if (sq<x) i=mid+1;
        	else j =mid -1;
        }
        return (int)j;
        /*  Å£¶Ùµü´ú·¨
         * int sqrt(int x) {
     if (x == 0) return 0;
     double last = 0;
     double res = 1;
     while (res != last)
     {
         last = res;
         res = (res + x / res) / 2;
     }
     return int(res);
    }
         */
    }
}