package leetCode.done;


public class Question42 {
    /**动态规划
     *
     */
//    public int trap(int[] height) {
//        if (height.length<=2) return 0;
//        int[] leftMax=new int[height.length];
//        int[] rightMax=new int[height.length];
//        leftMax[0]=height[0];
//        for (int i=1;i<height.length;i++){
//            leftMax[i]=Math.max(leftMax[i-1],height[i]);
//        }
//        rightMax[height.length-1]=height[height.length-1];
//        for (int i=height.length-2;i>=0;i--){
//            rightMax[i]=Math.max(rightMax[i+1],height[i]);
//        }
//
//        int res=0;
//        for (int i=0;i<height.length;i++){
//            int min=Math.min(leftMax[i],rightMax[i]);
//            if (height[i]<min){
//                res+=min-height[i];
//            }
//        }
//        return res;
//    }

    /**
     * 动态规划, 优化空间而来
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length<=2) return 0;
        int leftMax=0;
        int rightMax=0;
        int leftIndex=0;
        int rightIndex=height.length-1;
        int res=0;
        while (leftIndex<rightIndex){
            leftMax=Math.max(leftMax,height[leftIndex]);
            rightMax=Math.max(rightMax,height[rightIndex]);
            if (height[leftIndex]<height[rightIndex]){
                res+=leftMax-height[leftIndex];
                leftIndex++;
            }else {
                res+=rightMax-height[rightIndex];
                rightIndex--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] a={4,2,0/*,3,2,5*/};
//        int[] a={4,2/*,3,2,5*/};
        Question42 t=new Question42();
        int trap = t.trap(a);
        System.out.println(trap);
    }
}
