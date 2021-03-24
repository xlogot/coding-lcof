package question60.question65;

public class Question65 {
    static int add(int sum1,int sum2){
        int sum,carry;
        while (sum2!=0){
            sum=sum1^sum2;
            carry=(sum1&sum2)<<1;
            sum1=sum;
            sum2=carry;
        }
        return sum1;
    }

    public static void main(String[] args) {
        int add = add(1, 5);
        System.out.println(add);
    }
}
