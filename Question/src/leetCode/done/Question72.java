package leetCode.done;


public class Question72 {
    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        if (l1==0||l2==0){
            return l1==0 ? l2:l1;
        }
        int[][] matrix=new int[word2.length()+1][word1.length()+1];
        for (int i=0;i<matrix[0].length;i++){
            matrix[0][i]=i;
        }
        for (int i=0;i<matrix.length;i++){
            matrix[i][0]=i;
        }
        for (int j=1;j<word2.length()+1;j++){
            for (int i=1;i<word1.length()+1;i++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    matrix[j][i]=matrix[j-1][i-1];
                }else {
                    matrix[j][i]=1+Math.min(Math.min(matrix[j][i-1],matrix[j-1][i]),matrix[j-1][i-1]);
                }
            }
        }
        return matrix[word2.length()][word1.length()];
    }

    public static void main(String[] args) {
        String s="horse";
        String s1="ros";

        Question72 t=new Question72();
        int i = t.minDistance(s, s1);
        System.out.println(i);
    }
}
