package leetCode.done;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    public List<String> generateParenthesis(int n) {
        return  getList(new StringBuilder(),n,n,new ArrayList<>());
    }

    private List<String> getList(StringBuilder stringBuilder, int left, int right, ArrayList<String> lists) {
        if (left==0&&right==0){
            lists.add(stringBuilder.toString());
            return lists;
        }
        if (right>left){
            return lists;
        }
        if (left>0){
            stringBuilder.append("(");
            getList(stringBuilder,left-1,right,lists);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (right>0){
            stringBuilder.append(")");
            getList(stringBuilder,left,right-1,lists);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return lists;
    }
}
