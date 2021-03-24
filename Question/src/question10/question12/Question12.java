package question10.question12;
/*
题目:请设计一个函数，用来判断在一-个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3x4的矩阵中包含一条字符串“bfce”的路径(路径中的字母用下画线标出)。但矩阵中不包含字符串“abfb"的路径，因为字符串的第一一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
public class Question12 {
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if (matrix==null||rows<1||cols<1||str==null) return false;
        boolean[] visited=new boolean[rows*cols];
        int pathLength=0;
        for (int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if (hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
            if (pathLength==str.length) return true;
        boolean hasPath=true;
        if (row>=0&&row<rows&&col>=0&&col<cols//边界条件
                &&matrix[row*cols+col]==str[pathLength]//是否相等
                &&!visited[row*cols+col]//是否经过标记过的位置
        ){
            ++pathLength;
            visited[row*cols+col]=true;
            hasPath=hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,visited)
                    ||  hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,visited)
                    ||  hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,visited)
                    ||  hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,visited);

            if (!hasPath){
                --pathLength;
                visited[row*cols+col]=false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        String a ="abtgcfcsjdeh";
        char[] matrix=new char[a.length()];
        a.getChars(0,a.length(),matrix,0);
        String b="bfce";
        char[] str=new char[b.length()];
        b.getChars(0,b.length(),str,0);
        boolean res=hasPath(matrix,3,4,str);
//        char d=str[str.length];
        System.out.println(res);

    }
}
