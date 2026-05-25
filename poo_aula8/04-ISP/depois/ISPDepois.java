package isp;

import java.math.BigDecimal;
import isp.application.IntradayLimitMonitorV2;
import isp.contracts.StressTestRunner;
import isp.infrastructure.RiskPlatformHttpClient;

public class ISPDepois {
    public static void main(String[] args) {
        RiskPlatformHttpClient client = new RiskPlatformHttpClient();

        IntradayLimitMonitorV2 monitor = new IntradayLimitMonitorV2(client);
        monitor.checkLimit("PORTFOLIO-ALPHA", new BigDecimal("17000000.00"));

        StressTestRunner stressTestRunner = client;
        stressTestRunner.runStressTest("PORTFOLIO-ALPHA", "SCENARIO-2026-Q2");
    }
}
