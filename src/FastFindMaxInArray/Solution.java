//循环数组最大值
package FastFindMaxInArray;

public class Solution {
	public static void main(String[] args){
		int[] a={5,6,7,8,9,0,1,2,3,4};
		System.out.println(findMax(a));
		
		
	}
	private static int findMax(int[] a){
		int low=0;
		int high=a.length-1;
		int max=Integer.MIN_VALUE;
		while(low<high){
			int middle=(low+high)/2;
			if(a[middle]>a[low]){
				low=middle;
				continue;
			}
			else{
				high=middle;
				continue;
			}
			
		}
		return a[low];
	}
	

}
