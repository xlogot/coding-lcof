package question50.question53;

import java.util.Date;

public class Question53_2 {
    static int getMissingNumber(int[] data,int length){
        if (data==null||length<1) return -1;
        int missingNumberCore = getMissingNumberCore(data, length, 0, length - 1);
        return missingNumberCore==-1? -1:data[missingNumberCore];
    }

    private static int getMissingNumberCore(int[] data, int length,int start,int end) {
        if (start>end) return -1;
        if (start==length-1) {
            if (data[start]==start) return -1;
            else return start;
        }
        //获取中间值并比较它的下标
        int mid=(start+end)/2;
        int midNumber=data[mid];
        //如果中间下标等于其元素的值, 那么往后查找
        if (midNumber==mid){
            start=mid+1;
        }//下标不等于其元素的值
        else {
            //如果前一个元素的值,等于其下标, 那么直接返回, 如果它是第一个元素,那么也直接返回
            if (mid>0&&data[mid-1]==(mid-1)||mid==0){return mid;}
            //不相等的话, 继续往前查找
            else end=mid-1;
        }
        return getMissingNumberCore(data,length,start,end);
    }

    public static void main(String[] args) {
//        int[] a={0,1,2,3,4,6};
        int[] a={1};
        int missingNumber = getMissingNumber(a, a.length);
        System.out.println(missingNumber);
    }
}
