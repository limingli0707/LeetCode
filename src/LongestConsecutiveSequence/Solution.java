package LongestConsecutiveSequence;

import java.util.HashMap;

public class Solution {
	public int longestConsecutive(int[] num) {
	    HashMap<Integer, Integer> prevCons = new HashMap<Integer, Integer>();
	    HashMap<Integer, Integer> postCons = new HashMap<Integer, Integer>();
	    int longest = 1;

	    for(Integer i: num){
	        if(prevCons.containsKey(i))
	            continue;
	        if(prevCons.containsKey(i - 1))
	            prevCons.put(i, 1 + prevCons.get(i - 1));
	        else
	            prevCons.put(i, 1);

	        if(postCons.containsKey(i + 1))
	            postCons.put(i, 1 + postCons.get(i + 1));
	        else
	            postCons.put(i, 1);

	        //update left boundry
	        if(prevCons.containsKey(i - 1)){
	            int newPost = prevCons.get(i - 1) + postCons.get(i);
	            postCons.put(i - prevCons.get(i - 1), newPost);
	            longest = Math.max(longest, newPost);
	        }
	        //update right boundry
	        if(postCons.containsKey(i + 1)){
	            int newPrev = postCons.get(i + 1) + prevCons.get(i);
	            prevCons.put(i + postCons.get(i + 1), newPrev);
	            longest = Math.max(longest, newPrev);
	        }
	    }
	    return longest;
	}

}
/*
 *  int getCount(Set<Integer> hs, int v, boolean asc){
        int count=0;
        while(hs.contains(v)){
            hs.remove(v);
            count++;
            if(asc) v++; else v--;
        }
        return count;
    }
    
    public int longestConsecutive(int[] num) {
        Set<Integer> hs=new HashSet<Integer>();
        for(int v:num) hs.add(v);
        int ans=0;
        
        for(int v:num) if(hs.contains(v)) ans=Math.max(ans,getCount(hs, v, false)+getCount(hs, v+1, true));
        return ans; 
    }
