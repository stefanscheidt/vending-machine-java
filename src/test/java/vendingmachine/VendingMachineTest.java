package vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    @Test
    public void test1() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
    }
    
    @Test
    void test_insert_nickel() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("Nickel");
        assertEquals("0.05", vendingMachine.readDisplayText());
    }
    @Test
    void test_insert_dime() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("dime");
        assertEquals("0.1", vendingMachine.readDisplayText());
    }
}
