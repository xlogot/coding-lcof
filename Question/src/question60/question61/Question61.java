package question60.question61;

import java.awt.image.SampleModel;
import java.time.temporal.Temporal;

public class Question61 {
    static boolean isContinuous(int[] arrays){
        if (arrays==null||arrays.length!=5) return false;
        int numberOfZero=0;
        if (arrays[0]==0) numberOfZero++;
        for (int i=1;i<arrays.length;i++){
            int temp=arrays[i];
            int j;
            boolean changed=false;
            if (temp==0) numberOfZero++;
            for (j=i;j>0;j--){
                if (arrays[j-1]>temp) {
                    changed=true;
                    arrays[j]=arrays[j-1];
                }
                if (temp!=0&&temp==arrays[j-1]) return false;
            }
            if (changed)arrays[j]=temp;
        }
        int smallIndex=numberOfZero!=0? numberOfZero:0;
        int bigIndex= smallIndex+1;
        while (bigIndex<arrays.length){
            int gaps = arrays[bigIndex] - arrays[smallIndex]-1;
            numberOfZero-=gaps;
            if (numberOfZero<0) return false;
            smallIndex++;
            bigIndex++;

        }
        return true;
    }

    public static void main(String[] args) {
        int[] a={0,0,2,4,5};
        boolean continuous = isContinuous(a);
        System.out.println(continuous);
    }
}
