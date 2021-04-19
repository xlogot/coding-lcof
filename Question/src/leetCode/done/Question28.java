package leetCode.done;

public class Question28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack==null|| haystack.equals("")&&needle!=null) return -1;
        for (int i=0;i<haystack.length();i++){
            if (haystack.charAt(i)==needle.charAt(0)){
                for (int j=0;j<needle.length()&&(j+i)<haystack.length();j++){
                    if (needle.charAt(j)!=haystack.charAt(j+i)){
                        break;
                    }else {
                        if (j==needle.length()-1){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question28 t=new Question28();
        int i = t.strStr("mississippi",
                "sipp");
        System.out.println(i);
    }
}
