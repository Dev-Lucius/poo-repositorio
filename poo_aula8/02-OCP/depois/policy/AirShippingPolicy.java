package ocp.policy;

import java.math.BigDecimal;
import ocp.domain.ShippingOrder;

public class AirShippingPolicy implements ShippingCostPolicy {
    @Override
    public String mode() { return "AIR"; }

    @Override
    public BigDecimal calculate(ShippingOrder order) {
        return order.getDistanceKm().multiply(new BigDecimal("2.20"))
                .add(order.getWeightKg().multiply(new BigDecimal("0.95")));
    }
}
