package leetCode.done;

public class Question64 {
    public int minPathSum(int[][] grid) {
        int[][] matrix=new int[grid.length][grid[0].length];
        matrix[0][0]=grid[0][0];
        for (int i=1;i< matrix.length;i++){
            matrix[i][0]=grid[i][0]+matrix[i-1][0];
        }
        for (int i=1;i< matrix[0].length;i++){
            matrix[0][i]+=grid[0][i]+matrix[0][i-1];
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                matrix[i][j]=grid[i][j]+Math.min(matrix[i][j-1],matrix[i-1][j]);
            }
        }
        return matrix[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] a={{1,3,1},{1,5,1},{4,2,1}};
        Question64 t=new Question64();
        int i = t.minPathSum(a);
        System.out.println(i);
    }
}
