package question40.question46;

import java.util.concurrent.ConcurrentHashMap;

public class Question46_01 {
    static int intToString(int num){
        String s = String.valueOf(num);
        int length=s.length();
        char[] chars = s.toCharArray();
        int[] count=new int[length];
        for (int i=length-1;i>=0;i--){
            char c=chars[i];
            int temp=(int)c-'0';
            if (i<length-1&&temp<=2&&temp>0){//可以和后面的组成两位数
                char c1=chars[i+1];
                int temp1=(int) c1-'0';
                int t3=temp*10+temp1;
                if (t3<=25){
                    if (i<length-3){
                        count[i]=count[i+1]+count[i+2];
                    }else {
                        count[i]=count[i+1]+1;
                    }
                }else {
                    count[i]=count[i+1];
                }
            }else {//等于最后一位,或者只能代表一个字母
                if (i==length-1){
                    count[i]=1;
                }else count[i]=count[i+1];
            }
        }
        return count[0];
    }

    public static void main(String[] args) {
        int a=intToString(18580);
        System.out.println(a);
    }
}
