package question60.question64;

public class Question64 {
    public static void main(String[] args) {
        Sum[] a=new Sum[12];

        System.out.println(Sum.getTotalNumber());
    }
}
class Sum{
    static int totalNumber=0;
    int number=0;
    Sum(){
        totalNumber=totalNumber+1;
    }
    Sum(int n){
        totalNumber+=n;
        number=n;
    }
    static int getTotalNumber(){
        return totalNumber;
    }
}
