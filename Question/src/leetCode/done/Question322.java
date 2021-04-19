package leetCode;

public class Question322 {
    /**
     * 记忆搜索
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        return coinChange(coins,amount,new int[amount]);
    }
    int coinChange(int[] coins,int amount,int[] a){
        if (amount<0) return -1;
        if (amount==0) return 0;
        if (a[amount-1]!=0) return a[amount-1];
        int min=Integer.MAX_VALUE;
        for (int i:coins){
            int count=coinChange(coins,amount-i,a);
            if (count>=0&&(count+1)<min){
                min=count+1;
            }
        }
        a[amount-1]=min==Integer.MAX_VALUE ? -1:min;
        return a[amount-1];
    }

    /**
     * 动态规划
     * 设定初始值. a[0]=0; 循环从1开始
     */
    public int coinChange(int[] coins, int amount) {
        int[] a=new int[amount+1];
        for (int i=1;i<amount+1;i++){
            int min=amount+1;
            for (int c:coins){
                int count;
                if (i-c>=0){
                    count=a[i-c];
                    if (count>=0&&(count+1)<min){
                        min=count+1;
                    }
                }
            }
            a[i]= min>=(amount+1) ?-1:min;
        }
        return a[amount];
    }
    public static void main(String[] args) {
//        int[] coins={1,2,5};
//        int[] coins={2};
        int[] coins={2,5};
//        int[] coins={186,419,83,408};

        Question322 t=new Question322();
        int i = t.coinChange(coins, 11);
        System.out.println(i);
    }
}
