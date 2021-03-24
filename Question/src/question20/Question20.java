package question20;


//部分代码是重复的, 但是由于java语言的特殊性, 目前, 暂时没有想到将这些重复代码, 转化为函数.
public class Question20 {
    static boolean isNumeric(String str){
        if (str==null||str.equals("")) return false;
        char[] chars = str.toCharArray();
        int length = chars.length;
        //index一直往前走, 会超出边界, 时刻注意判断边界.
        int index=0;

        //判断小数前面的部分
        if ((chars[index]=='+'||chars[index]=='-')){
            index++;
        }
        boolean numeric;
        int start=index;
        //只有确定是数字了, index才会往前走
        while (index<length&&chars[index]>='0'&&chars[index]<='9'){
            index++;
        }
        numeric=index>start;

        //扫描数字的小数部分, 时刻注意边界条件
        if (index<length&&chars[index]=='.'){
            index++;
            int dotStart=index;
            while (index<length&&chars[index]>='0'&&chars[index]<='9'){
                index++;
            }
            //下面一行代码用|的原因:
            //1. 小数可以没有整数部分，如.123等于0.123;
            //2. 小数点后面可以没有数字，如233.等于233.0;
            //3.当然，小数点前面和后面可以都有数字，如233.666
            numeric=(index>dotStart)||numeric;
        }
        //扫描e后面的数字, 这部分的数字必须是整数
        if (index<length&&(chars[index]=='e'||chars[index]=='E')){
            index++;

            if ((chars[index]=='+'||chars[index]=='-')){
                index++;
            }
            //记录开始位置, 从而判断是否有数, 如果是其他数据则index不动, 不动就会导致下面的判断为false.
            int expStart=index;
            while (index<length&&chars[index]>='0'&&chars[index]<='9'){
                index++;
            }
            //1下面一行代码用&&的原因:
            //1.当e或E前面没有数字时，整个字符串不能表示数字，如.l、el;
            //2. 当e或E后面没有整数时，整个字符串不能表示数字，如12e、 12e+5.4
            //这里无法判断e后面的数是否为整数, 只要是一个数这里都给出true的结论,
            numeric=numeric&&(index>expStart);
        }
        //如果才是判断e后面的数是否为整数的条件, 如果是整数就说明, 整个字符串已经遍历完了,
        //如果是浮点数则没有遍历完, 因为前面的while判断碰到'.'就已经退出了
        return numeric&&(index==chars.length);
    }

    public static void main(String[] args) {
        String number="1.1e1";
        boolean numeric = isNumeric(number);
        System.out.println(numeric);
    }

}
