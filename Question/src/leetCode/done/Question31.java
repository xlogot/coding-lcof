package leetCode.done;


public class Question31 {
    public void nextPermutation(int[] nums) {
        if (nums.length<=1) return;
        int i1=-1;
        int temp=nums[nums.length-1];
        for (int i=nums.length-1;i>=0;i--){
            if (temp>nums[i]){
                i1=i;
                temp=nums[i];
                break;
            }
            temp=nums[i];
        }
        if (i1==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int i2=-1;
        for (int j=i1+1;j<nums.length;j++){
            if (nums[j]>temp){
                i2=j;
            }
        }
        exchange(nums,i1,i2);
        reverse(nums,i1+1,nums.length-1);
    }

    void reverse(int[] nums,int si,int ei){
        while (si<ei){
            exchange(nums,si++,ei--);
        }
    }

    private void exchange(int[] nums, int si, int ei) {
        int temp=nums[si];
        nums[si]=nums[ei];
        nums[ei]=temp;
    }

    public static void main(String[] args) {
        Question31 t=new Question31();
        int[] a={3,2,1};
        t.nextPermutation(a);
        for (int i:a){
            System.out.printf("%d, ",i);
        }
        System.out.println();
    }
}
