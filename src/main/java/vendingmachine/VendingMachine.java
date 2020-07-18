package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
	private Map<String, Integer> coins = new HashMap<>(){{
		put("nickel", Integer.valueOf(5)); 
		put("dime", Integer.valueOf(10));
		put("quarter", Integer.valueOf(25));
	}};
	private int amount;
	
	public String readDisplayText() {
		if (this.amount > 0) {
			return "" + this.amount / 100.0;
		}
		return "Insert Coin";
	}

	public void insert(final String coin) {
		this.amount += this.coins.getOrDefault(coin, 0);
	}
}
