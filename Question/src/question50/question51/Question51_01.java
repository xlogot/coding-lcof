package question50.question51;

public class Question51_01 {
    static int reversePairs(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int length=nums.length;
        int[] temp=new int[length];

        for (int i=nums.length-1;i>=0;i--){
            int count=0;
            int currentNumber=nums[i];
            for (int j=i+1;j<length;j++){
               int jNumber=nums[j];
               if (currentNumber>jNumber){
                   count=temp[j]+1+count;
               }
            }
            temp[i]=count;
        }
        return temp[0];
    }

    public static void main(String[] args) {
//        int[] a={7,5,6,4};
        int[] a={8,7,6,9,5};
        int i = reversePairs(a);
        System.out.println(i);
    }
}
