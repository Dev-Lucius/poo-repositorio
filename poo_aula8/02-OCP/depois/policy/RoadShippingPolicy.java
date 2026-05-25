package ocp.policy;

import java.math.BigDecimal;
import ocp.domain.ShippingOrder;

public class RoadShippingPolicy implements ShippingCostPolicy {
    @Override
    public String mode() { return "ROAD"; }

    @Override
    public BigDecimal calculate(ShippingOrder order) {
        return order.getDistanceKm().multiply(new BigDecimal("0.85"))
                .add(order.getWeightKg().multiply(new BigDecimal("0.30")));
    }
}
