package leetCode.done;

public class Question70 {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int i1=1;
        int i2=2;
        int i3=0;
        for(int i=3;i<=n;i++){
            i3=i1+i2;
            i1=i2;
            i2=i3;
        }
        return i3;
    }
}
