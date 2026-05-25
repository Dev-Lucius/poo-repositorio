package ocp.policy;

import java.math.BigDecimal;
import ocp.domain.ShippingOrder;

public class SeaShippingPolicy implements ShippingCostPolicy {
    @Override
    public String mode() { return "SEA"; }

    @Override
    public BigDecimal calculate(ShippingOrder order) {
        return order.getDistanceKm().multiply(new BigDecimal("0.40"))
                .add(order.getWeightKg().multiply(new BigDecimal("0.15")));
    }
}
