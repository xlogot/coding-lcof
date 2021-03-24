package question50.question57;

import java.util.SimpleTimeZone;

public class Question57_2 {
    static void findSequenceEqualsNumbers(int[] data,int number){
        if (data==null) return ;
        if (number<3) return;
        int headIndex=0;
        int tailIndex=1;
        int sum=0;
        sum=data[headIndex]+data[tailIndex];
        while (tailIndex-headIndex>0){
            //如果sum小于则tailIndex向后移动
            if(sum<number){
                if (tailIndex<data.length-1) {
                    tailIndex++;
                    sum+=data[tailIndex];
                }
            }else if (sum==number){
                System.out.println("headIndex: "+(1+headIndex)+" tailIndex: "+ (tailIndex+1));
                if (tailIndex<data.length-1) {
                    tailIndex++;
                    sum+=data[tailIndex];
                }
            }else {//sum大于num则,headIndex向后移动一格
                if (headIndex<data.length-1) {
                    sum=sum-data[headIndex];
                    headIndex++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        findSequenceEqualsNumbers(a,21);
    }
}
