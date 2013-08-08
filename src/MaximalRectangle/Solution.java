package MaximalRectangle;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
           if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
	       int[][] intMatrix = convertToInt(matrix);
	       
	       int[][] levelSum = getLevelSum(intMatrix);
	       
	       int max = -1;
	       for (int i = 0; i < matrix.length; i++) {
	           for (int j = i; j < matrix.length; j++) {
	               int[] sum = getSum(levelSum, i, j);
	               int tempLength = getMaxMatrix(sum, j - i + 1);
	               if (max < tempLength) {
	                   max =  tempLength;
	               }
	           }
	       }
	       return max;
	    }
	
	public int[][] getLevelSum(int[][] matrix){
		int[][] levelSum = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {
					levelSum[i][j] = matrix[i][j];
				} else {
					levelSum[i][j] = matrix[i][j] + levelSum[i - 1][j];
				}
			}
		}
		return levelSum;
	}
	    
	    public int getMaxMatrix(int[] sum, int rows) {
	        int start = 0;
	        int length = -1;
	        int i = 0;
	        for (; i < sum.length; i++) {
	            if (sum[i] != rows) {
	                if (length < i - start) {
	                    length = i - start;
	                }
	                start = i + 1;
	            }
	        }
	        if (i - start > length) {
	            length = i - start;
	        }
	        return rows * length;
	    }
	    
	    public int[][] convertToInt(char[][] matrix) {
	        int[][] converted = new int[matrix.length][matrix[0].length];
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                converted[i][j] = matrix[i][j] - '0';
	            }
	        }
	        return converted;
	    }
	    
	    public int[] getSum(int[][] matrix, int startRow, int endRow) {
	        int[] sum = new int[matrix[0].length];
	        if (startRow == 0) {
	        	for (int i = 0; i < sum.length; i++) {
	        		sum[i] = matrix[endRow][i];
	        	}
	        } else {
	        	for (int i = 0; i < sum.length; i++) {
	        		sum[i] = matrix[endRow][i] - matrix[startRow - 1][i];
	        	}
	        }
	        return sum;
	    }
}