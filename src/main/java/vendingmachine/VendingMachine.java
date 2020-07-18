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
	private String displayText;
	private boolean productSelected;

	public VendingMachine() {
		displayText = "Insert Coin";
	}

	public String readDisplayText() {
		if (this.amount > 0 && !productSelected) {
			return "" + this.amount / 100.0;
		}
		String resultingDisplayText = displayText;
		if (displayText.equals("THANK YOU!")) {
			displayText = "Insert Coin";
		}
		productSelected = false;
		return resultingDisplayText;
	}

	public void insert(final String coin) {
		this.amount += this.coins.getOrDefault(coin, 0);
	}

	public void selectCola() {
		if (this.amount == 100) {
			this.amount = 0;
			this.displayText = "THANK YOU!";
			return;
		}
		displayText = "PRICE 1.00";
		productSelected = true;
	}

	public void selectChips() {
		if (this.amount == 50) {
			this.amount = 0;
			this.displayText = "THANK YOU!";
			return;
		}
		displayText = "PRICE 0.50";
	}

	public void selectCandy() {
		if (this.amount == 65) {
			this.amount = 0;
			this.displayText = "THANK YOU!";
			return;
		}
		displayText = "PRICE 0.65";
		productSelected = true;
	}
}
