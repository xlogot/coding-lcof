package leetCode.done;

public class Question69 {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        long left=0,right=x;
        long mid;
        long ans=0;
        while (left<=right){
            mid=(left+right)/2;
            long res=mid*mid;
            if (res <= x) {
                ans=mid;
                left=mid+1;
            }else {
                right= mid-1;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Question69 t=new Question69();
        int i = t.mySqrt(2147395599);
        System.out.println(i);
    }
}