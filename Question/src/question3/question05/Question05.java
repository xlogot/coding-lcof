package question3.question05;

public class Question05 {
    //实现一个函数，把字符串中的每个空格替换成"%20"
    public static String replaceBlank(String string,int length){

        if (string==null) return null;

        StringBuffer temp=new StringBuffer(string);
        int blankNum=0;
        for (int i = 0; i < length; i++) {
            if (string.charAt(i)==' ') blankNum++;
        }
        int newLength=length+blankNum*2;
        temp.setLength(newLength);
        int index=length-1;
        int newIndex=newLength-1;
        while (newIndex!=index){
            var c1=temp.charAt(index--);
            if (c1!=' '){
                temp.setCharAt(newIndex--,c1);
            }else{
                temp.setCharAt(newIndex--,'0');
                temp.setCharAt(newIndex--,'2');
                temp.setCharAt(newIndex--,'%');
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        String test="we are happy";
        var t1=replaceBlank(test,test.length());
        System.out.println(t1);
        int[] c=new int[100];
    }
}
