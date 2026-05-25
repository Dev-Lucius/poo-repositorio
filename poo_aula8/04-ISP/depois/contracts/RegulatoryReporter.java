package isp.contracts;

public interface RegulatoryReporter {
    void submitRegulatoryReport(String reportId, byte[] payload);
}
