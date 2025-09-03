package br.com.mariojp.solid.srp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.mariojp.solid.srp.Item;
import br.com.mariojp.solid.srp.Order;
import br.com.mariojp.solid.srp.ReceiptFormatter;
import br.com.mariojp.solid.srp.ReceiptService;
import br.com.mariojp.solid.srp.TaxCalculator;

public class ReceiptServiceTest {

    @Test
    void uses_configured_tax_rate_of_8_percent() {
        System.setProperty("tax.rate", "0.08");

        TaxCalculator taxCalculator = new TaxCalculator();
        ReceiptFormatter receiptFormatter = new ReceiptFormatter();
        
        ReceiptService service = new ReceiptService(taxCalculator, receiptFormatter);
        
        Order order = new Order();
        order.add(new Item("Café", 8.0, 2));    // 16.0
        order.add(new Item("Bolo", 12.5, 1));   // 12.5 -> subtotal 28.5
        
        String receipt = service.generate(order);
        
        assertTrue(receipt.contains("Subtotal: 28,50"));
        assertTrue(receipt.contains("Imposto: 2,28")); // 28.5 * 0.08 = 2.28
        assertTrue(receipt.contains("Total: 30,78"));   // 28.5 + 2.28 = 30.78
    }
}