package question50.question53;

public class Question53 {
    static int GetFirstK(int[] data,int length,int k,int start,int end){
        if (start>end)  return -1;
        //求中间值
        int mid=(start+end)/2;
        int midNumber=data[mid];
        //中间这个数等于k
        if (midNumber==k){
            //如果前一个数比k小
            if (mid>0&&data[mid-1]<k||mid==0) return mid;
            //前一个数等于k, 往前找
            else end=mid-1;
        }
        //中间这个数比k小, 则向后进行查找第一个数
        else if (midNumber<k){
            start=mid+1;
        }//中间这个数比k大, 往前找.
        else end=mid+1;
        return GetFirstK(data,length,k,start,end);
    }
    static int GetLastK(int[] data, int length,int k,int start,int end){
        if (start>end) return -1;
        //求中间值
        int mid=(start+end)/2;
        int  midNumber=data[mid];
        //中间值大于k, 往前找
        if (midNumber>k){
            end=mid-1;
        }else if (midNumber<k){
            //中间值小于k, 往后找
            start=mid+1;
        }else {//中间值等于k
            //后一个值大于k, 返回mid, 要注意边界条件
            if (mid<length-1&&data[mid+1]>k||mid==length-1) return mid;
            //后一个值不大于, 则需要继续往后找
            start=mid+1;
        }
        return GetLastK(data,length,k,start,end);
    }
    static  int getNumberOfK(int[] data,int length,int k){
        if (data==null||length<=0) return -1;
        int first = GetFirstK(data, length, k, 0, length - 1);
        int last = GetLastK(data, length, k, 0, length - 1);
        return last-first+1;
    }

    public static void main(String[] args) {
        int[] a={3,3,3,3};
        int numberOfK = getNumberOfK(a, a.length, 3);
        System.out.println(numberOfK);
    }
}
