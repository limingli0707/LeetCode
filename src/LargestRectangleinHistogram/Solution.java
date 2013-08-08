package LargestRectangleinHistogram;

public class Solution {

}

//left[i] right[i] 分别表示 用height[i]作为高时，两边的边界。即左右都要大于height[i]
/*
class Solution {
public:
    int largestRectangleArea(vector &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(height.size() == 0)
            return 0;
        int *lefts = new int[height.size()+1];
        int *rights = new int[height.size()+1];
        for(int i = 0; i < height.size();i++)
        {
            lefts[i] = i;
            while(lefts[i]-1 >= 0 && height[i] <= height[lefts[i]-1])
            {
                lefts[i] = lefts[lefts[i]-1];
            }
        }
        for(int i = height.size() - 1;i >= 0;i--)
        {
            rights[i] = i;
            while(rights[i]+1 <= height.size()-1 && height[i] <= height[rights[i]+1])
            {
                rights[i] = rights[rights[i] + 1];
            }
        }
        int max = -1;
        for(int i = 0; i < height.size();i++)
        {
            if(height[i] * (rights[i] - lefts[i] + 1) > max)
            {
                max = height[i] * (rights[i] - lefts[i] + 1);
            }
        }
        return max;
    }
};
*/