package ReversInteger;

public class Solution {  
    public int reverse(int x) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        int negative=1;  
        if( x<0 ) {  
            negative = -1;  
            x = -x;  
        }  
          
        long y = x%10;  
          
        while( x/10 != 0 ) {  
            x /= 10;  
            y *= 10;  
            y += x%10;  
        }  
          
        if(y>Integer.MAX_VALUE) {  
            return -1;  
        } else {  
            return (int) (negative*y);  
        }  
    }  
}