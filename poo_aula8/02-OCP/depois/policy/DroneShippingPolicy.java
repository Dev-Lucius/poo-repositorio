package ocp.policy;

import java.math.BigDecimal;
import ocp.domain.ShippingOrder;

public class DroneShippingPolicy implements ShippingCostPolicy {
    @Override
    public String mode() { return "DRONE"; }

    @Override
    public BigDecimal calculate(ShippingOrder order) {
        return order.getDistanceKm().multiply(new BigDecimal("3.80"))
                .add(order.getWeightKg().multiply(new BigDecimal("1.60")));
    }
}
