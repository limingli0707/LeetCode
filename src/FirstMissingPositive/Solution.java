package FirstMissingPositive;
/*
 * 题目的最后一行，要求O(n)实际上暗示了用hash，但是又说要contant space，就没法再开新空间来建hash。
正好这个题目中处理的是1到n的数据，提供了一个将输入的数组同时用作hash表的可能性。
于是算法就是：

    第一遍扫描排除所有非正的数，将它们设为一个无关紧要的正数(n+2)，因为n+2不可能是答案
    第二遍扫描，将数组作为hash表来使用，用数的正负来表示一个数是否存在在A[]中。
    当遇到A[i]，而A[i]属于区间[1,n]，就把A中位于此位置A[i] – 1的数置翻转为负数。
    所以我们取一个A[i]的时候，要取它的abs，因为如果它是负数的话，通过步骤一之后，只可能是我们主动设置成负数的
    第三遍扫描，如果遇到一个A[i]是正数，说明i+1这个数没有出现在A[]中，只需要返回即可。
    上一步没返回，说明1到n都在，那就返回n+1

 */

class Solution {

    int firstMissingPositive(int A[], int n) {
        if(n <= 0)
            return 1;
        int intOutOfRange = n + 2;
        //first run, turn every negetive value into an impossible positive value
        //make every value in A is positive
        for(int i = 0 ; i < n ; ++ i) {
            if(A[i] <= 0)
                A[i] = intOutOfRange;
        }
        //second run, make A[] as a hash table, A[i] indicate the presence of i + 1
        //the way is that, if k in [1,n] is in A[], then turn A[k -1] to negetive
        for(int i = 0 ; i < n ; ++i) {
            int ai = A[i];
            int absi = Math.abs(ai);
            if(absi <= n)
                A[absi-1] = -Math.abs(A[absi-1]);
        }
        //third run, if A[i] is positive, from step 2, we know that i + 1 is missing.
        for(int i = 0 ; i < n ; ++i) {
            if(A[i] > 0)
                return i + 1;
        }
        //all int from 1 to n is present, then return n + 1
        return n+1;
    }
};
