package FirstMissingPositive;
/*
 * ��Ŀ�����һ�У�Ҫ��O(n)ʵ���ϰ�ʾ����hash��������˵Ҫcontant space����û���ٿ��¿ռ�����hash��
���������Ŀ�д������1��n�����ݣ��ṩ��һ�������������ͬʱ����hash��Ŀ����ԡ�
�����㷨���ǣ�

    ��һ��ɨ���ų����з�����������������Ϊһ���޹ؽ�Ҫ������(n+2)����Ϊn+2�������Ǵ�
    �ڶ���ɨ�裬��������Ϊhash����ʹ�ã���������������ʾһ�����Ƿ������A[]�С�
    ������A[i]����A[i]��������[1,n]���Ͱ�A��λ�ڴ�λ��A[i] �C 1�����÷�תΪ������
    ��������ȡһ��A[i]��ʱ��Ҫȡ����abs����Ϊ������Ǹ����Ļ���ͨ������һ֮��ֻ�����������������óɸ�����
    ������ɨ�裬�������һ��A[i]��������˵��i+1�����û�г�����A[]�У�ֻ��Ҫ���ؼ��ɡ�
    ��һ��û���أ�˵��1��n���ڣ��Ǿͷ���n+1

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
