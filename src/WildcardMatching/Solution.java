package WildcardMatching;

public class Solution {


	// passed java version
	// Time: O(|s||p|*log|s|), Space: O(|s|)
	// Time can also optimize to O(|s||p|)
	public boolean isMatch(String s, String p) {
	    // without this optimization, it will fail for large data set
	    int plenNoStar = 0;
	    for (char c : p.toCharArray())
	        if (c != '*') plenNoStar++;
	    if (plenNoStar > s.length()) return false;

	    s = " " + s;
	    p = " " + p;
	    int slen = s.length();
	    int plen = p.length();

	    boolean[] dp = new boolean[slen];
	    TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
	    firstTrueSet.add(0);
	    dp[0] = true;

	    boolean allStar = true;
	    for (int pi = 1; pi < plen; pi++) {
	        if (p.charAt(pi) != '*')
	            allStar = false;
	        for (int si = slen - 1; si >= 0; si--) {
	            if (si == 0) {
	                dp[si] = allStar ? true : false;
	            } else if (p.charAt(pi) != '*') {
	                if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') dp[si] = dp[si-1];
	                else dp[si] = false;
	            } else {
	                int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE : firstTrueSet.first();
	                if (si >= firstTruePos) dp[si] = true;
	                else dp[si] = false;
	            }
	            if (dp[si]) firstTrueSet.add(si);
	            else firstTrueSet.remove(si);
	        }
	    }
	    return dp[slen - 1];
	}

}
//C++ recursive
/*
 * class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (*p == '*'){//return true;
            while(*p == '*') ++p;
            if (*p == '\0') return true;
            while(*s != '\0' && !isMatch(s,p)){
                ++s;                
            }
            return *s != '\0';
        }
        else if (*p == '\0' || *s == '\0') return *p == *s;
        else if (*p == *s || *p == '?') return isMatch(++s,++p);
        else return false;
    }
};
//C++ DP
 /*
  * class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (!*s && !*p) return true;

        int ms_max = 1;//size of *s
        const char* ss = s;
        while(*ss){ ++ms_max;++ss;}
        int np_max = 1;
        const char* pp = p;
        while(*pp){if(*pp!='*')++np_max;++pp;}
        if(ms_max < np_max) return false;

        vector<vector<bool> > r(2, vector<bool>(ms_max, false));
        bool flag = 1;
        r[0][0] = true;
        do{//*p
            int ms = 1;
            ss = s;
            if (*p == '*'){
                while(*p == '*') ++p;
                --p;
                r[flag][0] = r[!flag][0];
                for( ;ms <= ms_max; ++ms){//up and left
                    if (r[!flag][ms] || r[flag][ms-1]) break;
                    else r[flag][ms] = false;
                }
                for(;ms <= ms_max; ++ms){
                    r[flag][ms] = true;
                }
            }
            else{
                do{
                    bool r_flag = false;
                    if (*ss == *p || *p == '?'){
                        r_flag = r[!flag][ms-1];//diagnal
                    }
                    r[flag][ms]=r_flag;
                    ++ms;++ss;
                }while(*ss);//*s
                r[flag][0] = false;
            }
            ++p;
            flag = !flag;
        }while(*p);
        return r[!flag][ms_max-1];
    }
};
  */

 
