package leetCode.done;

public class Question200 {
    /**
     *
     * @param
     */
//    public int numIslands(char[][] grid) {
//        boolean[][] a=new boolean[grid.length][grid[0].length];
//        int res=0;
//        for (int i=0;i<grid.length;i++){
//            for (int j=0;j<grid[0].length;j++){
//                if (grid[i][j]=='1'&& !a[i][j]){
//                    res++;
//                    setOthers(a,grid,i,j);
//                }
//            }
//        }
//        return res;
//    }
//
//    private void setOthers(boolean[][] a, char[][] grid, int i, int j) {
//        if (i>=grid.length||j>=grid[0].length) return;
//        if (grid[i][j]=='1'&& !a[i][j]){
//            a[i][j]=true;
//            setOthers(a,grid,i,j+1);
//            setOthers(a,grid,i+1,j);
//            setOthers(a,grid,i-1,j);
//            setOthers(a,grid,i,j-1);
//        }else {
//            return;
//        }
//    }

    /**
     * 使用辅助数组
     * 或者将1变为0, 标记为已经遍历了.
     * @param
     * @return
     */
    public int numIslands(String[][] grid) {
        boolean[][] a=new boolean[grid.length][grid[0].length];
        int res=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j].equals("1") && !a[i][j]){
                    res++;
                    setOthers(a,grid,i,j);
                }
            }
        }
        return res;
    }

    private void setOthers(boolean[][] a, String[][] grid, int i, int j) {
        if (i>=grid.length||j>=grid[0].length||i<0||j<0) return;
        if (grid[i][j].equals("1")&& !a[i][j]){
            a[i][j]=true;
            setOthers(a,grid,i,j+1);
            setOthers(a,grid,i+1,j);
            setOthers(a,grid,i-1,j);
            setOthers(a,grid,i,j-1);
        }else {
            return;
        }
    }
    public static void main(String[] args) {
        String[][] a={ {"1", "1", "1", "1", "0"},
                    {"0", "1", "0", "1", "0"},
                    {"1", "1", "1", "0", "0"},
                    {"0", "0", "0", "0", "0"}};
//        String[][] a={ {"1"},
//                        {"0"},
//                        {"0"},
//                        {"0"}};

        Question200 t=new Question200();
        int i = t.numIslands(a);
        System.out.println(i);
    }

}
