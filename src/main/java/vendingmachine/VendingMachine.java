package vendingmachine;

public class VendingMachine {
	private boolean coinInserted;
	private int amount;
	
	public String readDisplayText() {
		if (this.coinInserted) {
			return "" + amount / 100.0;
		}
		return "Insert Coin";
	}

	public void insert(final String coin) {
		switch (coin) {
			case "dime":
				amount += 10;
				break;
			case "Nickel":
				amount += 5;
				break;
		}
		this.coinInserted = true;
	}
}
