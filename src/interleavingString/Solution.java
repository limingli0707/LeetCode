package interleavingString;
//长度为i+j的s3 可由s1的前i个字符和s2的前j个字符组成
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
	    int m = s1.length();
	    int n = s2.length();
	    int s = s3.length();
	    if(m + n != s)
	        return false;

	    boolean[][] dp = new boolean[n + 1][m + 1];
	    dp[0][0] = true;

	    for(int i = 0; i < n + 1; i++)
	        for(int j = 0; j < m + 1; j++) {
	            if(dp[i][j] || (i - 1 >= 0 && dp[i - 1][j] == true && s2.charAt(i - 1) == s3.charAt(i + j - 1)) || ( j - 1 >= 0 && dp[i][j - 1] == true && s1.charAt(j - 1) == s3.charAt(i + j - 1)))
	                dp[i][j] = true;
	            else
	                dp[i][j] = false;
	    }

	    return dp[n][m];
	}

}
/*
public class Solution {
public boolean isInterleave(String s1, String s2, String s3) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s1.length()+s2.length()!=s3.length()) return false;
    if (s1.length()==0&&s2.length()==0&&s3.length()==0) return true;
    boolean[][] A = new boolean[s2.length()+1][s1.length()+1];
    A[0][0]=false;
    for (int i=0;i<s1.length();i++) {
        if ((i==0 || A[0][i]==true) && (s1.charAt(i)==s3.charAt(i))) {
            A[0][i+1]=true;
        } else
            A[0][i+1]=false;
    }
    for (int i=0;i<s2.length();i++) {
        if ((i==0 || A[i][0]==true) && (s2.charAt(i)==s3.charAt(i))) {
            A[i+1][0]=true;
        } else
            A[i+1][0]=false;
    }
    for (int i=0;i<s2.length();i++) {
        for (int j=0;j<s1.length();j++) {
            if (A[i][j+1] && s2.charAt(i)==s3.charAt(i+j+1)) {
                    A[i+1][j+1]=true;
            } else if (A[i+1][j]) {
                 if (s1.charAt(j)==s3.charAt(i+j+1))
                    A[i+1][j+1]=true;
                 else 
                    A[i+1][j+1]=false;
            } else 
                A[i+1][j+1]=false;
        }
    }
    return A[s2.length()][s1.length()];
}
}
*/