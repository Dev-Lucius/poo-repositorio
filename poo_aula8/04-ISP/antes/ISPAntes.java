import java.math.BigDecimal;

interface EnterpriseRiskGateway {
    BigDecimal getCurrentExposure(String portfolioId);

    void runStressTest(String portfolioId, String scenarioId);

    void submitRegulatoryReport(String reportId, byte[] payload);

    void synchronizeMarketData();

    void openOperationalIncident(String severity, String message);
}

class IntradayLimitMonitor implements EnterpriseRiskGateway {
    @Override
    public BigDecimal getCurrentExposure(String portfolioId) {
        return new BigDecimal("18450000.00");
    }

    @Override
    public void runStressTest(String portfolioId, String scenarioId) {
        throw new UnsupportedOperationException("Monitor de limite nao executa stress test");
    }

    @Override
    public void submitRegulatoryReport(String reportId, byte[] payload) {
        throw new UnsupportedOperationException("Monitor de limite nao envia reporte regulatorio");
    }

    @Override
    public void synchronizeMarketData() {
        throw new UnsupportedOperationException("Monitor de limite nao sincroniza market data");
    }

    @Override
    public void openOperationalIncident(String severity, String message) {
        throw new UnsupportedOperationException("Monitor de limite nao abre incidentes");
    }
}

public class ISPAntes {
    public static void main(String[] args) {
        EnterpriseRiskGateway monitor = new IntradayLimitMonitor();
        BigDecimal exposure = monitor.getCurrentExposure("PORTFOLIO-ALPHA");
        System.out.println("Exposicao atual: " + exposure);
    }
}
