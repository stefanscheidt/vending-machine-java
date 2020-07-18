package vendingmachine;

import java.text.DecimalFormat;
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
	private int change;

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
		if (this.amount >= 100) {
			change = amount - 100;
			resetAmountAndThankYou();
			return;
		}
		displayText = "PRICE 1.00";
		productSelected = true;
	}

	public void selectChips() {
		if (this.amount >= 50) {
			change = amount - 50;
			resetAmountAndThankYou();
			return;
		}
		displayText = "PRICE 0.50";
		productSelected = true;
	}

	public void selectCandy() {
		int price = 65;
		if (this.amount >= price) {
			change = amount - price;
			resetAmountAndThankYou();
			return;
		}
		displayText = "PRICE " + new DecimalFormat("#.00").format(price / 100.0);
		productSelected = true;
	}

	private void resetAmountAndThankYou() {
		this.amount = 0;
		this.displayText = "THANK YOU!";
	}

	public int getChange() {
		return change;
	}
}
