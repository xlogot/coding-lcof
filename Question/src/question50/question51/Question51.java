package question50.question51;

import java.time.chrono.MinguoChronology;
//在归并排序的过程中, 计算逆序对
public class Question51 {
    static int inversePairs(A1 data,int length){
        if (data==null||length<=0) return -1;
//        int[] clone = data.a.clone();
//        A1 copy=new A1();
//        copy.a=clone;
        return inversePairsCore(data,0,length-1);
    }

    private static int inversePairsCore(A1 data, int start, int end) {
        if (start==end){
            return 0;
        }
        int mid=(end-start)/2+start;

        int leftCount=inversePairsCore(data,start, mid);
        int rightCount=inversePairsCore(data,mid+1, end);
        int count=merge(data,start,mid,end);
        return leftCount+rightCount+count;
    }

    static int merge(A1 arrays,int left,int mid,int right){
        int[] copy = arrays.a.clone();
        int rightEnd=right;
        int leftEnd=mid;
        int arrayEnd=right;
        int count=0;
        while (leftEnd >= left && rightEnd > mid) {
            if (copy[leftEnd] >copy[rightEnd]) {
                arrays.a[arrayEnd--] = copy[leftEnd--];
                count += rightEnd - mid;
            } else {
                arrays.a[arrayEnd--] = copy[rightEnd--];
            }
        }
        if (leftEnd>=left){
            for (;leftEnd>=left;leftEnd--){
                arrays.a[arrayEnd--]=copy[leftEnd];
            }
        }else{
            for (;rightEnd>mid;rightEnd--){
                arrays.a[arrayEnd--]=copy[rightEnd];
            }
        }
//        copy.a=arrays.a;
        return count;
    }

    public static void main(String[] args) {
        int[] a={7,5,6,4};
        A1 a1=new A1();
        a1.a=a;
        int i = inversePairs(a1, a.length);
        System.out.println(i);
    }
    static class A1 {
        int[] a;
    }
}
