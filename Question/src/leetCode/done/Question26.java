package leetCode;

public class Question26 {
    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) return 0;

        int index=0;
        int cur=nums[0];
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==cur){
                count++;
            }else {
                cur=nums[i];
                count=1;
            }
            if (count<=1){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Question26 t=new Question26();
//        int[] a={0,0,0,1,2,3,3,4,4};
//        int[] a={0/*,0,0,1,2,3,3,4,4*/};
        int[] a={0,1,2,3,4};
        int i = t.removeDuplicates(a);
        for (int j=0;j<i;j++){
            System.out.printf("%d, ",a[j]);
        }
        System.out.println();
    }
}
