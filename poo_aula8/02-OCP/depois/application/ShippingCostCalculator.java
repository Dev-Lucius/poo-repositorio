package ocp.application;

import java.math.BigDecimal;
import java.util.List;
import ocp.domain.ShippingOrder;
import ocp.policy.ShippingCostPolicy;

public class ShippingCostCalculator {
    private final List<ShippingCostPolicy> policies;

    public ShippingCostCalculator(List<ShippingCostPolicy> policies) {
        this.policies = policies;
    }

    public BigDecimal calculate(ShippingOrder order, String mode) {
        for (ShippingCostPolicy policy : policies) {
            if (policy.mode().equalsIgnoreCase(mode)) {
                BigDecimal base = policy.calculate(order);
                if (order.isHazardousMaterial()) {
                    return base.multiply(new BigDecimal("1.35"));
                }
                return base;
            }
        }
        throw new IllegalArgumentException("Modal nao suportado: " + mode);
    }
}
