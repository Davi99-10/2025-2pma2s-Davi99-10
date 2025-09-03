package br.com.mariojp.solid.srp;

public class ReceiptService {

    private final TaxCalculator taxCalculator;
    private final ReceiptFormatter receiptFormatter;

    public ReceiptService(TaxCalculator taxCalculator, ReceiptFormatter receiptFormatter) {
        this.taxCalculator = taxCalculator;
        this.receiptFormatter = receiptFormatter;
    }

    public String generate(Order order) {
        double subtotal = order.getItems().stream()
                .mapToDouble(i -> i.getUnitPrice() * i.getQuantity())
                .sum();

        double tax = taxCalculator.calculate(subtotal);

        double total = subtotal + tax;

        return receiptFormatter.format(order, subtotal, tax, total);
    }
}