package question10.question19;

public class Question19 {
    static boolean match(String s,String p){
        if (s==null||p==null) return false;
        //添加结束符便于计算
        s=s+"\u0000";
        p=p+"\u0000";
        return matchCore(s,p);
    }

    private static boolean matchCore(String str1, String pattern1) {
        //在pattern没有'*'的情况下,两个字符串的长度必须相等, 下面两条语句就是判断他们是否相等.
        if (str1.equals("\u0000") && pattern1.equals("\u0000")) return true;
        //这条语句就是patter字符串结束了,而str还有, 无法做出后续判断, 则返回false. 但是加了'*'就另当别论,比如".*"就能匹配所有字符
        if (!str1.equals("\u0000") && pattern1.equals("\u0000")) return false;
        char[] strArray = str1.toCharArray();
        char[] patternArray = pattern1.toCharArray();
        boolean b = patternArray[0] == strArray[0] || (patternArray[0] == '.' && strArray[0] != '\u0000');
        //加上pattern长度判断就可以减少上面的这一句, 但是这样会减少可读性
        if (/*patternArray.length>1&&*/patternArray[1]=='*'){
            if (b)
                return      matchCore(str1.substring(1),pattern1.substring(2))
                        ||  matchCore(str1.substring(1),pattern1)
                        ||  matchCore(str1,pattern1.substring(2));
            else
                return matchCore(str1,pattern1.substring(2));

        }
        if (b)
            return matchCore(str1.substring(1),pattern1.substring(1));
        //所有不满足上述情况的将返回false.
        return false;
    }

    public static void main(String[] args) {
        String str="a";
        String patter="ab*";
        boolean match = match(str, patter);
        System.out.println(match);
    }
}
