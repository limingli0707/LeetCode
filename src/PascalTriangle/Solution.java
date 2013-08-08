package PascalTriangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) return listAll;
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (i == 0) {
                list.add(1);
            } else {
                ArrayList<Integer> prevList = listAll.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                       list.add(1); 
                    } else {
                        list.add(prevList.get(j-1) + prevList.get(j));
                    }
                }
            }
            listAll.add(list);
        }
        return listAll;        
    }
}
