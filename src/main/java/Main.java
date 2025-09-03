import br.com.mariojp.solid.srp.*;

public class Main {

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        ReceiptFormatter receiptFormatter = new ReceiptFormatter();

        ReceiptService receiptService = new ReceiptService(taxCalculator, receiptFormatter);

        Order order = new Order();
        order.add(new Item("Café", 8.0, 2));   // 16.0
        order.add(new Item("Bolo", 12.5, 1));  // 12.5 -> subtotal 28.5

        System.out.println("--- RECIBO COM TAXA PADRÃO (10%) ---");
        String receiptDefault = receiptService.generate(order);
        System.out.println(receiptDefault);
        
        System.setProperty("tax.rate", "0.08");
        System.out.println("\n--- RECIBO COM TAXA CONFIGURADA (8%) ---");
        String receiptCustomTax = receiptService.generate(order);
        System.out.println(receiptCustomTax);
    }
}