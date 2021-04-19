package leetCode;

public class Question75 {
    public void sortColors(int[] nums) {
        int index1=0;
        int index2=nums.length-1;
        int i=0;
        while (i<=index2){
            if (nums[i]==2){
                exchange(nums,i,index2);
                index2--;
            }else if (nums[i]==1){
                i++;
            }else {
                exchange(nums,i,index1);
                index1++;
                i++;
            }
        }
    }

    private void exchange(int[] nums, int index1, int index2) {
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    public static void main(String[] args) {

    }
}
