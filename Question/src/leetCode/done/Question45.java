package leetCode;


public class Question45 {
    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int[] a=new int[nums.length];
        a[0]=0;
        for (int i=1;i<a.length;i++){
            int min=Integer.MAX_VALUE;
            for (int j=1;i-j>=0;j++){
                int index=i-j;
                int jumpCount=nums[index];
                if (jumpCount>=j){
                    min=Math.min(min,a[index]+1);
                }
            }
            a[i]=min;
        }
        return a[nums.length-1];
    }

    public static void main(String[] args) {
//        int[] a={2,3,1,1,4,5};
//        int[] a={2/*,3,1,1,4,5*/};
//        int[] a={0,2,3};
        int[] a={0,2,0,0};
        Question45 t=new Question45();
        t.jump(a);
    }
}
