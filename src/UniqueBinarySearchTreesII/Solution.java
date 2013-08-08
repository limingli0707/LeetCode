package UniqueBinarySearchTreesII;
//Catalan numbe
//Cn = (2n!)/((n+1)!n!)
public class Solution {
 public int numTrees(int n) {
	 int[] d = new int[n+1];
	 d[0] = 1;
	 d[1] = 1;
	 for(int i=2; i<=n; i++) {
		 	for(int j=0; j<i; j++) { 
		 			d[i] += d[j] * d[i-j-1];
		 				}
	 			}
	 	return d[n];
 							}
 }

