package question10.question12;

import question3.question08.BinaryTreeNode;

public class Question12_1 {
    static boolean findPath(char[] matrix,int columns,int raws,char[] string){
        if (matrix==null||string==null) return false;
        int index = getIndex(matrix, string[0]);
        if (index<0) return false;
        int r1=index/columns;
        int c1=index%columns;
        boolean result=false;
        boolean[] visited=new boolean[matrix.length];
        visited[index]=true;
        result= findPath(matrix,raws,columns,string,1,c1+1,r1,visited)||
                findPath(matrix,raws,columns,string,1,c1-1,r1,visited)||
                findPath(matrix,raws,columns,string,1,c1,r1+1,visited)||
                findPath(matrix,raws,columns,string,1,c1,r1-1,visited);
        return result;
    }

    private static boolean findPath(char[] matrix, int raws, int columns, char[] string, int index, int c1, int r1,boolean[] visited) {
        if (c1<0||r1<0||c1>=columns||r1>=raws) return false;
        if (index==string.length) return true;
        int indexInMatrix =r1*columns+c1;
        if (visited[indexInMatrix]) return false;
        if (string[index]==matrix[indexInMatrix]) {
            visited[indexInMatrix]=true;
            return findPath(matrix,raws,columns,string,index+1,c1+1,r1,visited)||
                    findPath(matrix,raws,columns,string,index+1,c1-1,r1,visited)||
                    findPath(matrix,raws,columns,string,index+1,c1,r1+1,visited)||
                    findPath(matrix,raws,columns,string,index+1,c1,r1-1,visited);
        }
        else return false;
    }

    private static int getIndex(char[] matrix, char string) {
        int index=-1;
        for(int i=0;i<matrix.length;i++){
            if (matrix[i]==string){
                index=i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String a ="abtgcfcsjdeh";
        char[] matrix = a.toCharArray();
        String b="abfb";
        char[] chars = b.toCharArray();
        boolean b1 = findPath(matrix, 4, 3, chars);
        System.out.println(b1);
    }
}
