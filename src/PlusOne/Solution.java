package PlusOne;

public class Solution {

}
/*
 * class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> rel( digits.size() );
        
        int carry = 1;
        int x = 0;
        //char c;
        
        for( int i=digits.size()-1; i>=0; i--) {
            x = digits[i]  + carry;
            rel[i] = x%10;
            carry = x/10;
        }
        
        if(carry) {
            rel.insert( rel.begin(), carry);
        }
        
        return rel;
    }
};
 */
