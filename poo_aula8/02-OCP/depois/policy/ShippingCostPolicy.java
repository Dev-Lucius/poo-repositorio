package ocp.policy;

import java.math.BigDecimal;
import ocp.domain.ShippingOrder;

public interface ShippingCostPolicy {
    String mode();
    BigDecimal calculate(ShippingOrder order);
}
