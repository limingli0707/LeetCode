/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
package LetterCombinationsofaPhoneNumber;
/* C++ДњТы
class Solution {
public:
   vector<string> letterCombinations(string digits) {
    const string dict[] = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
    vector<string> ans;
    ans.push_back("");
    for(int i=0;i<digits.length();i++) {
        const string s = dict[digits[i]-'0'];
        vector<string> tmp;
        for(int j=0;j<s.length();j++) {
            for(int k=0;k<ans.size();k++) {
                tmp.push_back(ans[k]+string(1,s[j]));
            }    
        }   
        ans = tmp;
    }   
    return ans;
}
};
*/