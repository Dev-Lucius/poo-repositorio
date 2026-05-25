package ocp.domain;

import java.math.BigDecimal;

public class ShippingOrder {
    private final BigDecimal weightKg;
    private final BigDecimal distanceKm;
    private final boolean hazardousMaterial;

    public ShippingOrder(BigDecimal weightKg, BigDecimal distanceKm, boolean hazardousMaterial) {
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
        this.hazardousMaterial = hazardousMaterial;
    }

    public BigDecimal getWeightKg() { return weightKg; }
    public BigDecimal getDistanceKm() { return distanceKm; }
    public boolean isHazardousMaterial() { return hazardousMaterial; }
}
