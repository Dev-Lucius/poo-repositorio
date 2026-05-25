package isp.contracts;

import java.math.BigDecimal;

public interface ExposureQuery {
    BigDecimal getCurrentExposure(String portfolioId);
}
