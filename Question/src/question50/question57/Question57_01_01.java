package question50.question57;

import java.util.ArrayList;
import java.util.List;

public class Question57_01_01 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            int left=target-nums[i];
            result[0]=nums[i];
            int index=getIndex(nums,i+1,nums.length-1,left);
            if(index!=-1){
                result[1]=nums[index];
                return result;
            }
        }
        return result;
    }
    static int getIndex(int[] nums,int sI,int eI,int target){
        if(sI>eI) return -1;
        int mid=(eI+sI)/2;
        if(nums[mid]>target){
            return getIndex(nums,sI,eI,target);
        }else if(nums[mid]<target){
            return getIndex(nums,sI,mid-1,target);
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a={2,7,11,15};
        ArrayList<StringBuilder> li=new ArrayList<>();
        for (StringBuilder stringBuilder : li) {

        }
        int[] ints = twoSum(a, 9);

    }
}
