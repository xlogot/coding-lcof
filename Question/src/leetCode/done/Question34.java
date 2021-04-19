package leetCode;


public class Question34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};
        int leftIndex=getLeftIndex(nums, target);
        if (leftIndex==-1){
            return new int[]{-1,-1};
        }
        int rightIndex=getRightIndex(nums,target);
        if (leftIndex==-1){
            return new int[]{-1,-1};
        }
        return new int[]{leftIndex,rightIndex};
    }

    private int getRightIndex(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            //注意这里要向上取整
            int mid=(right+left+1)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]==target){
                left=mid;
            }else {
                left=mid+1;
            }
        }
        if (nums[left]!=target){
            return -1;
        }
        return left;
    }

    private int getLeftIndex(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(right+left)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]==target){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        if (nums[left]!=target){
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a={5,7,7,8,8,10};
        Question34 t=new Question34();
        int[] ints = t.searchRange(a, 8);
        for (int i:ints){
            System.out.println(i);
        }

    }
}
