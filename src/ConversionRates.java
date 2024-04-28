import com.google.gson.annotations.SerializedName;

public class ConversionRates {

    @SerializedName("USD")
    double usd;
    @SerializedName("BRL")
    double brl;
    @SerializedName("ARS")
    double ars;
    @SerializedName("COP")
    double cop;

    public double getUsd() {
        return usd;
    }

    public double getBrl() {
        return brl;
    }

    public double getArs() {
        return ars;
    }

    public double getCop() {
        return cop;
    }

}
