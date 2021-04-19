package leetCode.done;

public class Question14 {
    /**
     * 分治算法
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs==null||strs.length==0) return "";
//        List<Character> list= new ArrayList<>();
//        int min=getMin(strs);
//        boolean res=true;
//        int index=0;
//        while (index<min&&res&&getPrefix(strs,index,0,strs.length-1)){
//            index++;
//        }
//        if (res){
//            return strs[0].substring(0,index);
//        }
//        return "";
//    }
//    private int getMin(String[] strs) {
//        int res=strs[0].length();
//        for (String s:strs){
//            if (res>s.length()) res=s.length();
//        }
//        return res;
//    }
//    private boolean getPrefix(String[] strs, int index,int l,int r) {
//        if (r-l==1||r==l){
//            if (strs[l].equals("")||strs[r].equals("")) return false;
//            return strs[l].charAt(index)==strs[r].charAt(index);
//        }
//        int mid=(l+r)/2;
//        return getPrefix(strs,index,l,mid)&&getPrefix(strs,index,mid,r);
//    }

    /**
     * 穿针引线法, 纵向扫描
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int index=0;
        for (int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for (int j=0;j<strs.length;j++){
                if (strs[j].length()<=i||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,index);
                }
            }
            index++;
        }
        return strs[0].substring(0,index);
    }

    public static void main(String[] args) {
        String[] s={"flower","flow","floght"};
//        String[] s={"flower","flow",""};
//        String[] s={"a","aaaa"};
//        String[] s={""};
        Question14 t=new Question14();
        String s1 = t.longestCommonPrefix(s);
        System.out.println(s1);
    }
}
