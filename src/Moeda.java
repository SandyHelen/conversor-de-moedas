public class Moeda {
//    private String result;
    ConversionRates conversion_rates = new ConversionRates();

    public ConversionRates getConversion_rates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        return conversion_rates.usd + " " + conversion_rates.ars + " " + conversion_rates.brl + " " + conversion_rates.cop;
    }

}
