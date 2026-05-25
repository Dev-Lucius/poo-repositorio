package ocp;

import java.math.BigDecimal;
import java.util.Arrays;
import ocp.application.ShippingCostCalculator;
import ocp.domain.ShippingOrder;
import ocp.policy.AirShippingPolicy;
import ocp.policy.DroneShippingPolicy;
import ocp.policy.RoadShippingPolicy;
import ocp.policy.SeaShippingPolicy;

public class OCPDepois {
    public static void main(String[] args) {
        ShippingOrder order = new ShippingOrder(new BigDecimal("1200"), new BigDecimal("850"), true);

        ShippingCostCalculator calculator = new ShippingCostCalculator(Arrays.asList(
                new RoadShippingPolicy(),
                new AirShippingPolicy(),
                new SeaShippingPolicy(),
                new DroneShippingPolicy()
        ));

        BigDecimal cost = calculator.calculate(order, "DRONE");
        System.out.println("Custo logistica: " + cost);
    }
}
