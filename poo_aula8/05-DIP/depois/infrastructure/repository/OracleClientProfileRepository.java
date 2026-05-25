package dip.infrastructure.repository;

import java.math.BigDecimal;
import dip.contracts.ClientProfileRepository;
import dip.domain.ClientProfile;

public class OracleClientProfileRepository implements ClientProfileRepository {
    @Override
    public ClientProfile findByDocument(String document) {
        System.out.println("SQL(Oracle)> SELECT * FROM customers WHERE document='" + document + "'");
        return new ClientProfile(document, "CORPORATE", new BigDecimal("1250000.00"));
    }
}
