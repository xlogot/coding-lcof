package question10.question14;

import java.io.ObjectInputStream;

public class Question14_1 {
    static int maxProduct(int length){
        if (length<2) return 0;
        if (length==2) return 1;
        if (length==3) return 2;
        int[] products=new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        int max=0;
        for (int i=4;i<=length;i++){
            max=0;
            for (int j=1;j<=i/2;j++){
                int temp = products[j] * products[i - j];
                if (max<temp) max=temp;
            }
            products[i]=max;
        }
        return max;
    }
}
