package shopping.cart.fineas;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("greeting card", 0.86, 100);
        stockList.addStock(temp);


        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }


    }
}
