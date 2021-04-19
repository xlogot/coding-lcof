package leetCode.done;

public class Question53 {
    public int maxSubArray(int[] nums) {
        int[] res=new int[nums.length];
        res[0]=nums[0];
        int max=res[0];
        for (int i=1;i<nums.length;i++){
            if (res[i-1]<0){
                res[i]=nums[i];

            }else {
                res[i]=res[i-1]+nums[i];
            }
            if (max<res[i]){
                max=res[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        int[] a={2};
        Question53 t=new Question53();
        int i = t.maxSubArray(a);
        System.out.println(i);
    }
}
