package leetCode.done;

public class Question33 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;
        if (nums.length==1) return target==nums[0] ? 0:-1;
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(right+left)/2;
            if (nums[mid]==target){
                return mid;
            }
            //总有一边是单调的, 如果单调那边没有target, 则换一边, 继续,
            //否则二分查找, 巧的是这里和正常的二分查找类似
            if (nums[mid]>=nums[left]){
                if (target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {
                if (target<=nums[right]&&target>nums[mid]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={4,5,6,7,0,1,2};
//        int[] a={3,1};
        Question33 t=new Question33();
        int search = t.search(a, 1);
        System.out.println(search);
    }
}
