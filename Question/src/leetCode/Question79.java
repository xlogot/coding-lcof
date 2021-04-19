package leetCode;

public class Question79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] bool=new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        boolean res=false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                res=isExist(board,chars,0,i,j,bool);
                if (res) return true;
            }
        }
        return res;
    }

    private boolean isExist(char[][] board, char[] string, int stringIndex, int i, int j, boolean[][] bool) {
        if (stringIndex==string.length) return true;
        if (i<0||j<0||i>=board.length||j>=board[0].length) return false;
        if (string[stringIndex]!=board[i][j]) return false;
        if (!bool[i][j]){
            bool[i][j]=true;
            boolean res =   isExist(board, string, stringIndex + 1, i + 1, j, bool)||
                            isExist(board,string,stringIndex+1,i-1,j,bool)||
                            isExist(board,string,stringIndex+1,i,j-1,bool)||
                            isExist(board,string,stringIndex+1,i,j+1,bool);
            if (!res) bool[i][j]=false;
            return res;

        }else return false;
    }

    public static void main(String[] args) {
        Question79 t=new Question79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'A'}};
//        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        boolean abcced = t.exist(board, "AAB");
//        boolean abcced = t.exist(board, "ABCCED");
//        boolean abcced = t.exist(board, "ABCB");
        boolean abcced = t.exist(board, "EESCE");
//        boolean abcced = t.exist(board, "EESC");
//        boolean abcced = t.exist(board, "A");
        System.out.println(abcced);
    }
}
