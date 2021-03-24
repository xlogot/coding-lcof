package question10;

import jdk.jfr.Unsigned;

/*
求斐波那契数列第n项
 */
public class Question10 {
    //解法1：递归的解法。通常是不推荐的,从上往下解决问题
    public static long fibonacci1(int n){
        if (n<=0) return 0;
        if (n==1) return 1;
        return fibonacci1(n-1)+fibonacci1(n-2);
    }
    //解法2：改进，记录中间项。时间复杂度是O(n) 从下往上解决问题
    public static long fibonacci2(int n){
        if (n<0) return -1;
        long[] result={0,1};
        if (n<=1){
            return result[n];
        }
        long fibOne=1;
        long fibTwo=0;
        long fibN=0;
        for (int i = 2; i <= n; i++) {
            fibN=fibOne+fibTwo;
            fibOne=fibTwo;
            fibTwo=fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        long a=fibonacci2(2);
    }
}
