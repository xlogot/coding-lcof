package leetCode.done;

import java.util.ArrayList;
import java.util.List;

public class Question46 {
    /**
     * 回溯, 给定初始为空的列表
     * @param nums
     * @return
     */
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length==0) return list;
        List<Integer> path=new ArrayList<>();
        dfs(nums,0, path);
        return list;
    }

    private void dfs(int[] nums, int n, List<Integer> path) {
        if (n==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i=n;i<nums.length;i++){
            exchange(nums,n,i);
            path.add(nums[n]);
            dfs(nums,n+1,path);
            exchange(nums,n,i);
            path.remove(n);
        }
    }

    private void exchange(int[] nums, int index, int i) {
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
    }

    public static void main(String[] args) {
        Question46 t=new Question46();
        int[] a={1,2,3};
        List<List<Integer>> permute = t.permute(a);
    }

}
