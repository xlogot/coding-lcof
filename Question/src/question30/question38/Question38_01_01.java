package question30.question38;

public class Question38_01_01 {
    static void permutation(String string){
        char[] chars = string.toCharArray();
        pCore(chars,0);
    }

    private static void pCore(char[] chars, int index) {
        if (index==chars.length-1){
            System.out.println(String.valueOf(chars));
            return;
        }
        for (int i=index;i<chars.length;i++){
            exchange(chars,index,i);
            pCore(chars,index+1);
            exchange(chars,i,index);

        }
    }

    private static void exchange(char[] chars, int target,int index) {
        if (index==target)  return;
        char temp=chars[target];
        chars[target]=chars[index];
        chars[index]=temp;
    }

    public static void main(String[] args) {
        String a="abcd";
        permutation(a);
    }
}
