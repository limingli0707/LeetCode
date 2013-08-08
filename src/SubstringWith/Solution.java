package SubstringWith;

import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (L.length == 0) {
            return ret;
        }
 
        //I will create another string array without the duplcates
        ArrayList<String> l = new ArrayList<String>();
        ArrayList<Integer> c = new ArrayList<Integer>();
 
        Arrays.sort(L);
        for (int i = 0; i < L.length; i++) {
            l.add(L[i]);
            int count = 1;
            while (i+1 < L.length && L[i].equals(L[i+1])) {
                i++;
                count++;
            }
            c.add(count);
        }
 
        int[] starts = new int[S.length()];
 
 
        for (int i = 0; i < S.length(); i++) {
            starts[i] = -1;
            for (int j = 0; j < l.size(); j++) {
                if (S.substring(i).startsWith(l.get(j))) {
                    starts[i] = j;
                }
            }
        }
 
        int step = L[0].length();
 
        for (int i = 0; i <= S.length() - step*L.length; i++) {
            int[] perm = new int[L.length];
            boolean needTest = true;
            for (int j = 0; j < L.length; j++) {
                perm[j] = starts[i+j*step];
                if (perm[j] == -1) {
                    needTest = false;
                }
            }   
            if (needTest && testPerm(perm, c)) {
                ret.add(i);
            }
        }
 
        return ret;
    }
 
    private boolean testPerm (int[] perm, ArrayList<Integer> c) {
        int[] count = new int1;
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
 
        for (int i = 0; i < perm.length; i++) {
            count[perm[i]]++;
        }
 
        for (int i = 0; i < count.length; i++) {
            if (count[i] != c.get(i)) {
                return false;
            }
        }
 
        return true;
    }
}