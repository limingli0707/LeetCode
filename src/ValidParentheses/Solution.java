package ValidParentheses;
/*C++
class Solution {
public:
    bool isValid(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<char> myStack;
        char c;
        
        for( int i=0; i<s.size(); i++) {
            if( s[i] == '(' || s[i] == '[' || s[i] == '{') {
                myStack.push( s[i] );
            } else if( myStack.empty() ) {
                return false;
            } else if( s[i] == ')') {
                c = myStack.top();
                if( c!= '(' ) return false;
                else myStack.pop();
            } else if( s[i] == ']') {
                c = myStack.top();
                if( c!= '[' ) return false;
                else myStack.pop();
            } else if( s[i] == '}') {
                c = myStack.top();
                if( c!= '{' ) return false;
                else myStack.pop();
            } else {
                return false;
            }  
        }
        
        return myStack.empty();
    }
};
*/
