package LongestPalindromicSubstring;
/*
 * 方法一 动态规划
 */
public class Solution {
	
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	boolean[][] dp;
    	if(s.length()==0){
    		return "";
    	}
    	if(s.length()==1){
    		return s;
    	}
    	
    	dp = new boolean[s.length()][s.length()];
    	
    	int i,j;
    	
    	for( i=0;i<s.length();i++){
    		for(j=0;j<s.length();j++){
    			if(i>=j){ // i==j 是回文，当i>j 空也是回文
    				dp[i][j]=true;
    			}
    			else {
    				dp[i][j]=false;
    			}
    		}
    	}
    	
    	int k; //每次去寻找长度为k+1的回文子串
    	int maxlen=0; //用来记录当前最长回文子串的长度
    	int rf=0,rt=0;//用来记录当前最长回文子串的起始和末尾
    	
    	for(k=1;k<s.length();k++){
    		for(i=0;i+k<s.length();i++){
    			j=i+k;
    			if(s.charAt(i)!=s.charAt(j)){
    				dp[i][j]=false;
    			}
    			else{
    				dp[i][j]=dp[i+1][j-1];
    				if(dp[i][j]){
    					if(k+1>maxlen){
    						maxlen = k+1;
    						rf=i;
    						rt=j;
    					}
    				}
    			}
    			
    		}
    	}
        return s.substring(rf, rt+1);
    }
}