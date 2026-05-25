import java.math.BigDecimal;

class ShipmentOrder {
    private final BigDecimal weightKg;
    private final BigDecimal distanceKm;
    private final boolean hazardousMaterial;

    ShipmentOrder(BigDecimal weightKg, BigDecimal distanceKm, boolean hazardousMaterial) {
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
        this.hazardousMaterial = hazardousMaterial;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public BigDecimal getDistanceKm() {
        return distanceKm;
    }

    public boolean isHazardousMaterial() {
        return hazardousMaterial;
    }
}

class ShippingCostService {
    public BigDecimal calculate(ShipmentOrder order, String mode) {
        BigDecimal base;

        if ("ROAD".equalsIgnoreCase(mode)) {
            base = order.getDistanceKm().multiply(new BigDecimal("0.85"))
                    .add(order.getWeightKg().multiply(new BigDecimal("0.30")));
        } else if ("AIR".equalsIgnoreCase(mode)) {
            base = order.getDistanceKm().multiply(new BigDecimal("2.20"))
                    .add(order.getWeightKg().multiply(new BigDecimal("0.95")));
        } else if ("SEA".equalsIgnoreCase(mode)) {
            base = order.getDistanceKm().multiply(new BigDecimal("0.40"))
                    .add(order.getWeightKg().multiply(new BigDecimal("0.15")));
        } else if ("RAIL".equalsIgnoreCase(mode)) {
            base = order.getDistanceKm().multiply(new BigDecimal("0.65"))
                    .add(order.getWeightKg().multiply(new BigDecimal("0.25")));
        } else {
            throw new IllegalArgumentException("Modal nao suportado: " + mode);
        }

        if (order.isHazardousMaterial()) {
            base = base.multiply(new BigDecimal("1.35"));
        }

        return base;
    }
}

public class OCPAntes {
    public static void main(String[] args) {
        ShipmentOrder order = new ShipmentOrder(new BigDecimal("1200"), new BigDecimal("850"), true);
        ShippingCostService service = new ShippingCostService();

        BigDecimal cost = service.calculate(order, "AIR");
        System.out.println("Custo logistica: " + cost);

        // Para adicionar um novo modal (ex.: DRONE), seria preciso alterar esta classe.
    }
}
