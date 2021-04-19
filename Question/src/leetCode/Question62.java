package leetCode;

public class Question62 {
    public int uniquePaths(int m, int n) {
        int[][] grid=new int[n][m];
        for (int i=0;i<grid.length;i++){
            grid[i][0]=1;
        }
        for (int i=0;i<grid[0].length;i++){
            grid[0][i]=1;
        }
        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid[0].length;j++){
                grid[i][j]=grid[i-1][j]+grid[i][j-1];
            }
        }
        return grid[n-1][m-1];
    }

    public static void main(String[] args) {
        Question62 t=new Question62();
        int i = t.uniquePaths(3, 3);
        System.out.println(i);
    }
}
