package LongestPalindromicSubstring;
/*
 * ����һ ��̬�滮
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
    			if(i>=j){ // i==j �ǻ��ģ���i>j ��Ҳ�ǻ���
    				dp[i][j]=true;
    			}
    			else {
    				dp[i][j]=false;
    			}
    		}
    	}
    	
    	int k; //ÿ��ȥѰ�ҳ���Ϊk+1�Ļ����Ӵ�
    	int maxlen=0; //������¼��ǰ������Ӵ��ĳ���
    	int rf=0,rt=0;//������¼��ǰ������Ӵ�����ʼ��ĩβ
    	
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