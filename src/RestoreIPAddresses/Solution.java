package RestoreIPAddresses;

import java.util.ArrayList;

public class Solution {

public static ArrayList restoreIpAddresses(String s) {
         ArrayList rs = new ArrayList();
         if(s.length() < 4) return rs;
        
        String s0 = new String();
        helper(rs, s, s0, 4);
        return rs;
}
    
static void helper(ArrayList rs, String s, String s0, int remain) {
         if(remain == 0) {
                  if(s.isEmpty())
                         rs.add(s0.substring(0, s0.length()-1));
                  else return;
        }
        else if(s.isEmpty()) return;
        
        else {
                int up = 255;
        
                String s1 = s0;
                if(s.charAt(0) == '0'|| s.length()==1) {
                        s1 = s1.concat(s.substring(0,1)).concat(".");
                        helper(rs, s.substring(1), s1, remain-1);
                }
                else {
                       if(s.length()>=3) {
                                s1 = s1.concat(s.substring(0,1)).concat(".");
                                helper(rs, s.substring(1), s1, remain-1);
        
                                s1 = s0;
                                s1 = s1.concat(s.substring(0,2)).concat(".");
                                helper(rs, s.substring(2), s1, remain-1);
       
                                s1 = s0;
                                int temp = Integer.parseInt(s.substring(0,3));
                                if(temp <= up) {
                                        s1 = s1.concat(s.substring(0,3)).concat(".");
                                        helper(rs, s.substring(3), s1, remain-1);
                                }
                        }
                        if (s.length() == 2) {
                                s1 = s1.concat(s.substring(0,1)).concat(".");
                                helper(rs, s.substring(1), s1, remain-1);
       
                                s1 = s0;
                                s1 = s1.concat(s.substring(0,2)).concat(".");
                                helper(rs, s.substring(2), s1, remain-1);
                         }
                 }
           }
 }


}
