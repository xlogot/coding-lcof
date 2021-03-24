package question10.question14;

import static java.lang.Math.pow;

public class Question14 {
    int maxProductAfterCutting_solution1(int length){
        //这里直接返回结果
        if (length<2) return 0;
        if (length ==2) return 1;
        if (length==3) return 2;
        int[] products=new int[length+1];
        //这里不一样, 这前四个结果集,不能作为结果.
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;

        int max;
        for (int i = 4; i <= length; i++) {
            max=0;
            for (int j=1;j<= i/2;j++){
                int product=products[j]*products[i-j];
                if (max<product) max=product;
                products[i]=max;
            }
        }

        max=products[length];
        return max;
    }

    //贪心算法, 每次选择最优的选择.
    int maxProductAfterCutting_solution2(int length){
        //这里直接返回结果
        if (length<2) return 0;
        if (length ==2) return 1;
        if (length==3) return 2;
        if (length==4) return 4;
        int max=0;
        int timesOf3=length/3;
        if (length-timesOf3*3==1) timesOf3-=1;
        int timesOf2=(length-timesOf3*3)/2;
        return (int)(pow(3,timesOf3)*(int)(pow(2,timesOf2)));
    }
}
