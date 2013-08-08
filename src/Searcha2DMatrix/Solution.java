package Searcha2DMatrix;

public class Solution {
	 public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row =matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
        	if(matrix[i][column-1]>=target){//所找的值在这一行里 采用二分查找
        		return BinarySearch.binarySearch(matrix[i], target);}
        	else{
        		continue;
        	}
        		
        		
        	}
        return false;
        }
    }


class BinarySearch {
/**
* 二分查找算法
*
* @param srcArray 有序数组
* @param des 查找元素
* @return des的数组下标，没找到返回-1
*/
public static boolean binarySearch(int[] srcArray, int des)
{
int low = 0;
int high = srcArray.length-1;
while(low <= high) {
int middle = (low + high)/2;
if(des == srcArray[middle]) {
return true;
}else if(des <srcArray[middle]) {
high = middle - 1;
}else {
low = middle + 1;
}
}
return false;
}
}