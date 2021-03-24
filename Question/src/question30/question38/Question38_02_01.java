package question30.question38;

public class Question38_02_01 {
    static void combine(String string){
        if (string==null||string=="") return;
        for (int i=1;i<=string.length();i++){
            cCore(string,i);
        }
    }
    private static void cCore(String string, int combineLength) {
        if (string.length()<combineLength) return;
        //包含第一个元素
        boolean contains=true;
        if (combineLength==1){
            char[] chars1 = string.toCharArray();
            for(char a:chars1){
                System.out.println(a);
            }
        } else {
            //长度大于2
            StringBuilder sb=new StringBuilder();
            sb.append(string.charAt(0));
            String substring = string.substring(1);
            cCore(substring,combineLength-1,sb);
            cCore(substring,combineLength);
        }
    }
    private static void cCore(String string, int combineLength,StringBuilder sb){
        if (combineLength==0) return;
        StringBuilder sb1=new StringBuilder();
        sb1.append(sb);
        if (combineLength==1){
            char[] chars = string.toCharArray();
            for (char a:chars){
                System.out.println(sb.toString()+a);
            }
            return;
        }
        //固定第一个
        String substring = string.substring(1);
        sb.append(string.charAt(0));
        cCore(substring,combineLength-1,sb);
        if (substring.length()>combineLength) cCore(substring,combineLength,sb1);
    }

    public static void main(String[] args) {
        String a="a";
        combine(a);
    }
}
