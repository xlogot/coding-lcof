package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question39 {
    /**
     * 回溯算法解决
     * 注意去重
     */
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> p=new ArrayList<>();
        getList(candidates,target,p,0);
        return list;
    }

    private void getList(int[] candidates, int nums, List<Integer> path,int index) {
        if (nums==0){
            list.add(new ArrayList<>(path));
            return;
        }
        int left;
        for (int i=index;i<candidates.length;i++){
            left=nums-candidates[i];
            if (left<0) continue;
            path.add(candidates[i]);
            getList(candidates,left,path,i);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        Question39 t=new Question39();
        int[] can={2,3,6,7};
        List<List<Integer>> list = t.combinationSum(can, 8);
    }
}
