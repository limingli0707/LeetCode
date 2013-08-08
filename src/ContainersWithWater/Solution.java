package ContainersWithWater;

public class Solution {//Ҳ������˫��forѭ������ �������Ч�ʸ���
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (max < min(height[i], height[j]) * (j - i)) {
                max = min(height[i], height[j]) * (j - i);
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
    
    int min(int a, int b) {
        if (a < b) return a;
        return b;
    }
}