package leetCode.done;

public class Question50 {
    /**
     * 暴力解法
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if(x==0) return 1.0d;
        if (x<0){
            x=-x;
            double  res=x;
            for (int i=1;i<n;i++){
                res=res*x;
            }
            return 1/x;
        }else {
            double res=x;
            for (int i=1;i<n;i++){
                res=res*x;
            }
            return res;
        }
    }
    /**
     * 分支算法, 递归
     */
    public double myPow2(double x, int n) {
        if (x==1||n==0) return 1;
        if (n<0){
            return 1/powHelper(x,-n);
        }else {
            return powHelper(x,n);
        }
    }

    private double powHelper(double x, int i) {
        if (i==1) return x;
        if (i%2!=0){
            return powHelper(x,i/2)*powHelper(x,i/2)*x;
        }
        return powHelper(x,i/2)*powHelper(x,i/2);
    }

    /**
     * 分治, 迭代
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if ((N & 1) == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N =N>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question50 t1=new Question50();
        double v = t1.myPow(-2, 3);
        System.out.println(v);
    }
}
