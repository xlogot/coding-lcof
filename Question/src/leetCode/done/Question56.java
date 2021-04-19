package leetCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question56 {
    /**
     * 1. 二维数组的排序
     * 2. 初始的时候判定
     * 3.
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][2];
        }
        //先进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> merge=new ArrayList<>();
        //在进行比较
        for (int i=0;i<intervals.length;i++){
            int l=intervals[i][0], r=intervals[i][1];
            //这里判定到为true是就不会执行下去了
            if (merge.size()==0||merge.get(merge.size()-1)[1]<l){
                merge.add(new int[]{l,r});
            }else {
                merge.get(merge.size()-1)[1]=Math.max(merge.get(merge.size()-1)[1],r);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
