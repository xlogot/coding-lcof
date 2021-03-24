package question10.question12;

public class personalCode {
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if (matrix==null||rows<1||cols<1||str==null) return false;
        boolean[] visited=new boolean[rows*cols];
        int pathLength=0;
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (core(matrix,rows,cols,row,col,str,pathLength,visited)) return true;
            }
        }
        return false;
    }

    private static boolean core(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (str[pathLength] == '\0') return true;
        boolean hasPath=false;
        if (matrix[row * cols + col] == str[pathLength]
                && col < cols && row < rows &&row>=0&&col>=0
                && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = core(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || core(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || core(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || core(matrix, rows, cols, row - 1, col, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
