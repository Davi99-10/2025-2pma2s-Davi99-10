package br.com.mariojp.solid.srp;

public class ReceiptFormatter {

    public String format(Order order, double subtotal, double tax, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RECIBO ===\n");
        
        for (var item : order.getItems()) {
            sb.append(String.format("%s x%d = %.2f\n", 
                item.getName(), 
                item.getQuantity(), 
                (item.getUnitPrice() * item.getQuantity())));
        }
        
        sb.append("----------------\n");
        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("Imposto: %.2f\n", tax));
        sb.append(String.format("Total: %.2f\n", total));
        
        return sb.toString();
    }
}