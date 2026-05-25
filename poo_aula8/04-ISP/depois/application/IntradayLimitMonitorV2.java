package isp.application;

import java.math.BigDecimal;
import isp.contracts.ExposureQuery;

public class IntradayLimitMonitorV2 {
    private final ExposureQuery exposureQuery;

    public IntradayLimitMonitorV2(ExposureQuery exposureQuery) {
        this.exposureQuery = exposureQuery;
    }

    public void checkLimit(String portfolioId, BigDecimal limit) {
        BigDecimal exposure = exposureQuery.getCurrentExposure(portfolioId);
        if (exposure.compareTo(limit) > 0) {
            System.out.println("ALERTA: limite excedido para " + portfolioId + ". Exposicao=" + exposure);
            return;
        }
        System.out.println("Limite OK para " + portfolioId + ". Exposicao=" + exposure);
    }
}
