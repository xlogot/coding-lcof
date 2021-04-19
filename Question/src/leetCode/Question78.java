package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question78 {
    List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path=new ArrayList<>();
        for (int i=0;i<=nums.length;i++){
            backTrack(nums,i,0,path);
        }
        return lists;
    }

    private void backTrack(int[] nums, int length, int start, List<Integer> path) {
        if (length<=0){
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backTrack(nums, length-1, i+1, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Question78 t=new Question78();
        int[] a={1,2,3};
        List<List<Integer>> subsets = t.subsets(a);
    }
}
