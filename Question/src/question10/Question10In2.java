package question10;

import javax.net.ssl.SSLEngine;

public class Question10In2 {
    static int numberOfSteps(int level){
        if (level<=0) return 0;
        if (level==1) return 1;
        if (level==2)  return 2;
        return numberOfSteps(level-1)+numberOfSteps(level-2);
    }

    static long numberOfSteps1(int level){
        if (level<=0) return 0;
        if (level==1) return 1;
        if (level==2)  return 2;
        long temp1=1;
        long temp2=2;
        long t=0;
        for (int i=3;i<=level;i++){
            t=temp1+temp2;
            temp1=temp2;
            temp2=t;
        }
        return t;
    }

    public static void main(String[] args) {
//        int i = numberOfSteps(10);
//        System.out.println(i);
        long i2=numberOfSteps1(5);
        System.out.println(i2);
    }
}
