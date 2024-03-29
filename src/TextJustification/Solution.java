package TextJustification;

public class Solution {

}
/*
 * class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> ret;
        int begin = 0, len = 0, n = words.size();
        for (int i = 0; i < n; ++i) {
            if (len + words[i].size() + (i - begin) > L) {
                ret.push_back(connect(words, begin, i - 1, len, L, false));
                begin = i;
                len = 0;
            } 
            len += words[i].size();
        }
        ret.push_back(connect(words, begin, n - 1, len, L, true));
        return ret;
    }

    string connect(vector<string> &words, int begin, int end, int len, int L, bool leftJustify) {
        string s;
        int n = end - begin + 1;
        for (int i = 0; i < n; ++i) {
            s += words[begin + i];
            addSpaces(s, i, n - 1, L - len, leftJustify);
        }

        if (s.size() < L) s.append(L - s.size(), ' ');
        return s;
    }

    void addSpaces(string &s, int i, int n, int L, bool leftJustify) {
        if (n < 1 || i > n - 1) return;
        int spaces = leftJustify ? 1 : (L / n + (i < (L % n) ? 1 : 0));
        s.append(spaces, ' ');
    }
};
 */
*/