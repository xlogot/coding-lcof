package leetCode.done;

public class Question1411 {
    /**
     * 将类型分为ABA,ABC.
     * 当n=1时, ABA=6;ABC=6
     * 当n=2时, ABA类型可以接受类型共计: ABA有3种, ABC有2种
     *          ABA类型可以接受类型共计: ABA有2种, ABC有2种
     * 因此: 当n=2时, ABA(这里的ABA类型就是最下面这层的类型)的类型总共有:    6*3+6*2  ,
     *                  ABC:            6*2+6*2
     * @param n
     * @return
     */
    public int numOfWays(int n) {
        final int mod=10_0000_0007;
        if(n==1){
            return 12;
        }
        long aba=6;
        long abc=6;
        long newA=0;
        long newB=0;
        for (int i=2;i<=n;i++){
            newA=(3*aba+2*abc)%mod;
            newB=(2*aba+2*abc)%mod;
            aba=newA;
            abc=newB;
        }
        return (int)((aba+abc)%mod);
    }
}
