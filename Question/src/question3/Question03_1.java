package question3;

import java.util.LinkedHashMap;
import java.util.jar.JarEntry;

public class Question03_1 {
    static int duplicate(int[] arrays){
        if (arrays==null) return -1;
        for(int i=0;i<arrays.length;i++){
            //数组的下标和对应的相等
            while (arrays[i]!=i){
                if (arrays[i]>=arrays.length) return -1;
                //如果下标对应的元素不等于对应的值, 那么就进行交换
                int a=arrays[arrays[i]];
                if (a==arrays[i]){//这里说明了它们相等.那么直接返回
                    return a;
                }
                arrays[arrays[i]]=arrays[i];
                arrays[i]=a;
            }
        }
        return -1;
    }
    static int duplicateNoAlter(int[] arrays,int left,int right){
        if (arrays==null) return -1;
        if (left==right)  return left;
        int mid=(left+right)/2;
        int leftCount=0;
        int rightCount=0;
        for (int i=0;i<arrays.length;i++){
            if (arrays[i]<=mid&&arrays[i]>=left) leftCount++;
            else if (arrays[i]<=right&&arrays[i]>mid) rightCount++;
        }
        if (leftCount>(mid-left+1)) return duplicateNoAlter(arrays,left,mid);
        else if (rightCount>(right-mid))return duplicateNoAlter(arrays,mid+1,right);
        else return -1;
    }

    static void bubbleSort(int[] arrays){
        for (int i=arrays.length-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (arrays[j]>arrays[j+1]){
                    int temp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=temp;
                }
            }
        }
    }

    static void insertSort(int[] arrays){
//        LinkedHashMap
        for (int i=1;i<arrays.length;i++){
            int temp=arrays[i];
            int j;
            for (j=i;j>0&&arrays[j-1]>temp;j--){
                arrays[j]=arrays[j-1];
            }
            arrays[j]=temp;
        }
    }

    public static void main(String[] args) {
        int[] nums={7,6,6,5,4,3,2,1};
        insertSort(nums);
        int duplicate = duplicateNoAlter(nums,1,nums.length-1);
        System.out.println(duplicate);
    }
}
