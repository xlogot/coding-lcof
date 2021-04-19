package leetCode;

public class Question55 {
    public boolean canJump(int[] nums) {
        int rightMostIndex=0;
        for (int i=0;i<nums.length;i++){
            if (i<=rightMostIndex){
                rightMostIndex=Math.max(nums[i]+i,rightMostIndex);
                if (rightMostIndex>=nums.length-1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question55 t=new Question55();
        int[] a={1,1,2,0};
        boolean b = t.canJump(a);
        System.out.println(b);
    }
}
