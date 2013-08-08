package EditDistance;
//http://blog.csdn.net/ihavenoidea/article/details/526764
public class Solution {
	public int minDistance(String word1, String word2) {
	    if(word2.length() == 0)
	        return word1.length();

	    int[] distance = new int[word2.length() + 1];
	    for(int k = 1; k <= word2.length(); k++)
	        distance[k] = k;

	    for(int i = 0; i < word1.length(); i++){
	        int []curDistance = new int[word2.length() + 1];
	        curDistance[0] = i + 1; 
	        for(int j = 0; j < word2.length(); j++){
	            int substitute = distance[j] + (word1.charAt(i) == word2.charAt(j)? 0 : 1);
	            int delete = distance[j + 1] + 1;
	            int insert = curDistance[j] + 1;
	            curDistance[j + 1] = Math.min(substitute, Math.min(delete, insert));
	        }
	        distance = curDistance;
	    }

	    return distance[word2.length()];
	}
}

/*
 * 
 * class Solution { public:
    int minDistance(string word1, string word2) {
        int ar[word1.size()+1][word2.size()+1];
        for(int i=0;i<=word1.size();i++)
            ar[i][0]=i;
        for(int j=0;j<=word2.size();j++)
            ar[0][j]=j;
        for(int i=1;i<=word1.size();i++)
        {
            for(int j=1;j<=word2.size();j++)
            {
                if(word1[i-1]==word2[j-1])
                    ar[i][j]=ar[i-1][j-1];
                else
                {
                    int mn=min(ar[i-1][j],ar[i][j-1]);
                    ar[i][j]=1+min(ar[i-1][j-1],mn);
                }
            }
        }
        return ar[word1.size()][word2.size()];   
    } };
    
    
    
    
    
    
    
    
    
    
    
    

class Solution {
public:
    int minDistance(string word1, string word2) {
        if(word1.empty() || word2.empty()) return max(word1.length(), word2.length());

        vector<vector<int> > mt(word1.length()+1, vector<int>(word2.length()+1, 0));
        for(int i = 1; i < word2.length() + 1; i++) 
            mt[0][i] = i;
        for(int j = 1; j < word1.length() + 1; j++)
            mt[j][0] = j;
        mt[0][0] = 0;

        for(int i = 1; i < word2.length()+1; i++) {
            for(int j = 1; j < word1.length()+1; j++) {
                if(word1[j-1] == word2[i-1]) mt[j][i] = mt[j-1][i-1];
                else mt[j][i] = 1 + mt[j-1][i-1];
                mt[j][i] = min(mt[j][i], mt[j-1][i]+1);
                mt[j][i] = min(mt[j][i], mt[j][i-1]+1);
            }
        }
        return mt[word1.length()][word2.length()];
    }
};
 */
*/