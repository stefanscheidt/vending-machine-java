package vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    @Test
    public void test1() {
        final VendingMachine vendingMachine = new VendingMachine();
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
    }
    
    @Test
    void test_insert_nickel() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        assertEquals("0.05", vendingMachine.readDisplayText());
    }
    @Test
    void test_insert_dime() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("dime");
        assertEquals("0.1", vendingMachine.readDisplayText());
    }
    
    @Test
    void test_insert_quarter() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("quarter");
        assertEquals("0.25", vendingMachine.readDisplayText());
    }
    
    @Test
    void test_two_coins() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("dime");
        vendingMachine.insert("quarter");
        assertEquals("0.35", vendingMachine.readDisplayText());
    }
    
    @Test
    void test_three_coins() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        vendingMachine.insert("dime");
        vendingMachine.insert("quarter");
        assertEquals("0.4", vendingMachine.readDisplayText());
    }

    @Test
    void test_penny_insert_do_nothing() {
        final VendingMachine vendingMachine = new VendingMachine();        
        vendingMachine.insert("penny");
        assertEquals("0.0", vendingMachine.readDisplayText());
    }
}
