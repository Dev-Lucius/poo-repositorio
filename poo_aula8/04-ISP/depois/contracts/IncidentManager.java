package isp.contracts;

public interface IncidentManager {
    void openOperationalIncident(String severity, String message);
}
