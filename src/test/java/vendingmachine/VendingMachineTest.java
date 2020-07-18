package vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
    }

    @Test
    void test_nickel_and_penny_insert_do_nothing() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        vendingMachine.insert("penny");
        assertEquals("0.05", vendingMachine.readDisplayText());
    }
    
    // TODO test product 1 without money displays the price of product 1
    @Test @DisplayName("test_product_one_without_money")
    void testProductOneWithoutMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectCola();
        assertEquals("PRICE 1.00", vendingMachine.readDisplayText());
    }
    
    @Test @DisplayName("test_product_two_without_money")
    void testProductTwoWithoutMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectChips();
        assertEquals("PRICE 0.50", vendingMachine.readDisplayText());
    }

    @Test @DisplayName("test_product_three_without_money")
    void testProductThreeWithoutMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectCandy();
        assertEquals("PRICE 0.65", vendingMachine.readDisplayText());
    }
    @Test @DisplayName("test_candy_with_insufficient_money")
    void test_candy_with_insufficient_money() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        vendingMachine.selectCandy();
        assertEquals("PRICE 0.65", vendingMachine.readDisplayText());
        assertEquals("0.05", vendingMachine.readDisplayText());
    }

    @Test @DisplayName("test_cola_with_insufficient_money")
    void test_cola_with_insufficient_money() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        vendingMachine.selectCola();
        assertEquals("PRICE 1.00", vendingMachine.readDisplayText());
        assertEquals("0.05", vendingMachine.readDisplayText());
    }

    @Test @DisplayName("test_chips_with_insufficient_money")
    void test_chips_with_insufficient_money() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        vendingMachine.selectChips();
        assertEquals("PRICE 0.50", vendingMachine.readDisplayText());
        assertEquals("0.05", vendingMachine.readDisplayText());
    }

    @Test @DisplayName("test product candy with enough money")
    void testProductCandyWithEnoughMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("nickel");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("dime");
        vendingMachine.selectCandy();
        assertEquals("THANK YOU!", vendingMachine.readDisplayText());
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
    }
    
    @Test @DisplayName("test product cola with correct money")
    void testProductColaWithCorrectMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.selectCola();
        assertEquals("THANK YOU!", vendingMachine.readDisplayText());
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
    }

    @Test @DisplayName("test product chips with correct money")
    void testProductChipsWithCorrectMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.selectChips();
        assertEquals("THANK YOU!", vendingMachine.readDisplayText());
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
    }


    @Test @DisplayName("test product chips with more money")
    void testProductChipsWithMoreMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.selectChips();
        assertEquals("THANK YOU!", vendingMachine.readDisplayText());
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
        assertEquals(25, vendingMachine.getChange());
    }
    
    @Test @DisplayName("test product chips with more money")
    void testProductColaWithMoreMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("nickel");    
        vendingMachine.selectCola();
        assertEquals("THANK YOU!", vendingMachine.readDisplayText());
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
        assertEquals(5, vendingMachine.getChange());
    }
    
    @Test @DisplayName("test product candy with more money")
    void testProductCandyWithMoreMoney() {
        final VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.insert("quarter");
        vendingMachine.selectCandy();
        assertEquals("THANK YOU!", vendingMachine.readDisplayText());
        assertEquals("Insert Coin", vendingMachine.readDisplayText());
        assertEquals(10, vendingMachine.getChange());
    }
}
