package WordLadder2;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public static ArrayList<ArrayList<String>> wordLadderII(String start, String end, HashSet<String> dict){
	    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
	    ArrayList<String> path = new ArrayList<String>();
	    wordLadderIIHelper(start, end, dict, path, ret);

	    int min = 0;
	    for(ArrayList<String> item : ret){
	        min = min == 0 || item.size() < min ? min = item.size() : min;
	    }

	    for(int i = 0; i < ret.size(); i++){
	        if(ret.get(i).size() > min)
	            ret.remove(i--); // REMEMBER the  "i--" when removing elements from ArrayList
	    }
	    return ret;
	}
	public static void wordLadderIIHelper(String start, String end, HashSet<String> dict, ArrayList<String> path, ArrayList<ArrayList<String>> ret){
	    path.add(start);
	    char[] sArr = start.toCharArray();
	    for(int i = 0; i < sArr.length; i++){
	        char origin = sArr[i];
	        for(char c = 'a'; c <= 'z'; c++){
	            if(c != origin){
	                sArr[i] = c;
	                String temp = new String(sArr);
	                if(temp.equals(end)){
	                    path.add(temp);
	                    ret.add(new ArrayList<String>(path));
	                    path.remove(path.size() - 1);
	                }
	                if(dict.contains(temp) && !path.contains(temp)) 
	                    wordLadderIIHelper(temp, end, dict, path, ret);
	            }
	        }
	        sArr[i] = origin;
	    }
	    path.remove(path.size() - 1);
	}

}
