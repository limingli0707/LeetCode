package LengthofLastWord;



public class Solution {
public int lengthOfLastWord(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int p = s.length()-1;
    int len=0;
    boolean trailing=true;
    while (p>=0) {
        if (s.charAt(p) != ' ') {
            len ++;
            trailing=false;
            p --;
        } else if (trailing) {
            p--;
        } else {
            break;
        }
    }
    return len;
}
}