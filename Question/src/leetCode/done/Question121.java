package leetCode.done;

public class Question121 {
    public int maxProfit(int prices[]) {
        if(prices==null) return 0;
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }else if (prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
