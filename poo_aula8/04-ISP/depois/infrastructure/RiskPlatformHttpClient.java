package isp.infrastructure;

import java.math.BigDecimal;
import isp.contracts.ExposureQuery;
import isp.contracts.IncidentManager;
import isp.contracts.MarketDataSynchronizer;
import isp.contracts.RegulatoryReporter;
import isp.contracts.StressTestRunner;

public class RiskPlatformHttpClient implements ExposureQuery, StressTestRunner, RegulatoryReporter,
        MarketDataSynchronizer, IncidentManager {

    @Override
    public BigDecimal getCurrentExposure(String portfolioId) {
        System.out.println("HTTP GET /risk/exposure?portfolioId=" + portfolioId);
        return new BigDecimal("18450000.00");
    }

    @Override
    public void runStressTest(String portfolioId, String scenarioId) {
        System.out.println("HTTP POST /risk/stress-test portfolioId=" + portfolioId + " scenario=" + scenarioId);
    }

    @Override
    public void submitRegulatoryReport(String reportId, byte[] payload) {
        System.out.println("HTTP POST /regulatory/reports id=" + reportId + " payloadSize=" + payload.length);
    }

    @Override
    public void synchronizeMarketData() {
        System.out.println("HTTP POST /market-data/sync");
    }

    @Override
    public void openOperationalIncident(String severity, String message) {
        System.out.println("HTTP POST /incidents severity=" + severity + " message=" + message);
    }
}
