package programming.injava.array;

import java.util.ArrayList;
import java.util.List;

public class BuySellStock {

	public static List<OrderBook> findOrderBook(int[] stockPrice) {
		
		List<OrderBook> orderBooks = new ArrayList<>();
		
		int n = stockPrice.length;
		
		for(int i = 0; i < n - 1; ) {
			OrderBook orderBook = new OrderBook();
			
			while(i < (n - 1) && stockPrice[i + 1] <= stockPrice[i]) i++;
			
			if(i == n-1) break;
			
			orderBook.buyIndex = i++;
			
			while(i < n && stockPrice[i] >= stockPrice[i - 1]) i++;

			orderBook.sellIndex = i - 1;
			
			orderBooks.add(orderBook);
		}
		
		return orderBooks;
	}
	
	
	public static void main(String[] args) {
		
		int[] stockPrice = {100, 180, 260, 310, 40, 535, 695};
		
		List<OrderBook> orderBooks = findOrderBook(stockPrice);
		
		orderBooks.stream().forEach(System.out::println);
	}
}

class OrderBook {
	int buyIndex;
	int sellIndex;
	
	public String toString() {
		return "[Buy on day: " + buyIndex + ", Sell on day:" + sellIndex  +"]";
	}
}
