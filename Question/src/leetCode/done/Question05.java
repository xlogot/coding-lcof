package leetCode.done;

public class Question05 {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int[][] matrix=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            matrix[i][i]=1;
        }
        int si=0;
        int length=1;
        for(int j=1;j<s.length();j++){
            for (int i=0;i<j;i++){
                if (s.charAt(i)==s.charAt(j)&&(j-i<3||matrix[j-1][i+1]>0)){
                    matrix[j][i]=matrix[j-1][i+1]+2;
                    if (matrix[j][i]>length){
                        length=j-i+1;
                        si=i;
                    }
                }else {
                    matrix[j][i]=0;
                }
            }
        }
        return s.substring(si,length+si);
    }

    public static void main(String[] args) {
//        String s="babad";
//        String s="ba";
//        String s="aabcdedcbaff";
//        String s="cbbd";
        String s="aacabdkacaa";
        Question05 t=new Question05();
        String s1 = t.longestPalindrome(s);
        System.out.println(s1);
    }
}
