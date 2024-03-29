/*
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
package ImplementStr;
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        if (needle.length() == 0) return haystack;
        if (needle.length() > haystack.length()) return null;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean isPass = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isPass = false;
                    break;
                }
            }
            if (isPass == true) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
