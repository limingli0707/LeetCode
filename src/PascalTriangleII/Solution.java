package PascalTriangleII;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        if (rowIndex < 0) return list;
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                list2.add(1);
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                       list2.add(1); 
                    } else {
                        list2.add(list.get(j-1) + list.get(j));
                    }
                }
            }
            ArrayList<Integer> temp = list;
            list = list2;
            list2 = temp;
            list2.clear();
        }
        return list;        
        
    }
}
