package question10.question15;


public class Question15 {
    public static int numberOf1(int n){
        //为负数时, 会进入死循环, 因为最高位会一直为1
        //可以从最高位进行比较, 这样就能避免出现问题
        int count=0;
        while (n!=0){
            if ((n&Integer.MIN_VALUE)==Integer.MIN_VALUE) count++;
            n=n<<1;
        }
        return count;
    }
    public int numberOf1Solution2(int n){
        int count=0;
        int i=1;
        int t=i&0xffffff;
        while (t!=0){
            if ((n&t)==1) count++;
            t=t<<1;
        }
        return count;
    }
    public int numberOf1Solution3(int n){
        int count=0;
        while (n!=0){
            int x=n-1;
            n=n&x;
            count++;
        }
        return count;
    }

    /*
    用一条语句判断一个整数是不是2的整数次方。一个整数如果是2
    的整数次方，那么它的二进制表示中有且只有一位是1,而其他所
    有位都是0。根据前面的分析，把这个整数减去1之后再和它自己
    做与运算，这个整数中唯一-的1就会变成0。
     */
    public boolean checkNumberIs2(int number){
        return ((number-1)&number)==0;
    }

    /*
    输入两个整数m和n，计算需要改变m的二进制表示中的多少位
    才能得到n. 比如10的二进制表示为1010， 13的二进制表示为
    1101，需要改变1010中的3位才能得到1101。 我们可以分为两步
    解决这个问题:第一步求这两个数的异或;第二步统计异或结果中
    1的位数。
     */
    public int numbersOfBits(int a,int b){
        int c=a^b;
        return numberOf1Solution3(c);
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(0b111));
    }
}
