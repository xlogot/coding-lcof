package question50.question53;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question53_3 {
    static int findElementEqualToIndex(int[] data,int length){
        if (data==null||length<1) return -1;
        return findElementEqualToIndex(data,length,0,length-1);
    }

    private static int findElementEqualToIndex(int[] data, int length, int start, int end) {
        if (start>end) return -1;
        //计算中间值
        int mid=(start+end)/2;
        int midNumber=data[mid];
        //如果中间的元素的值大于下标, 判断前一个元素的下标是否和其元素值相等.
        if (midNumber>mid){
            //前一个元素相等则直接返回mid-1, 同时要注意数组越界功能, 此时还要注意是否到了第一个下标
            if (mid>0&&data[mid-1]==(mid-1)||mid==0) return mid-1;
            else end=mid-1;
        }//如果中间元素和下标相等, 判断后一个元素是否不相等, 否则往后找,
        else if (mid==midNumber){
            if (mid<length-1&&data[mid+1]!=(mid+1)||mid==length-1) return mid;
            start=mid+1;
        }//中间元素小于下标, 往后找
        else {
            start=mid+1;
        }
        return findElementEqualToIndex(data, length, start, end);
    }

    public static void main(String[] args) {
//        int[]  a={-1,1,3,4,5,6};
        int[]  a={-1,0,1,3};
//        int[]  a={-1,0,2};
        int index = findElementEqualToIndex(a, a.length);
        System.out.println(index);
    }
}
