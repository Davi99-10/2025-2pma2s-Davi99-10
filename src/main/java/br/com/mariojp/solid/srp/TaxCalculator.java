package br.com.mariojp.solid.srp;

public class TaxCalculator {
    
    private static final double DEFAULT_TAX_RATE = 0.10; 

       public double calculate(double subtotal) {
        String taxRateProperty = System.getProperty("tax.rate");
        double taxRate = DEFAULT_TAX_RATE;

        if (taxRateProperty != null && !taxRateProperty.isEmpty()) {
            try {
                taxRate = Double.parseDouble(taxRateProperty);
            } catch (NumberFormatException e) {
                System.err.println("Formato de taxa inválido: " + taxRateProperty + ". Usando taxa padrão.");
            }
        }
        
        return subtotal * taxRate;
    }
}