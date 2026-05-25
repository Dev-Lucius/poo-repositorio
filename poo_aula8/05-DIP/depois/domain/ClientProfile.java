package dip.domain;

import java.math.BigDecimal;

public class ClientProfile {
    private final String document;
    private final String segment;
    private final BigDecimal monthlyRevenue;

    public ClientProfile(String document, String segment, BigDecimal monthlyRevenue) {
        this.document = document;
        this.segment = segment;
        this.monthlyRevenue = monthlyRevenue;
    }

    public String getDocument() { return document; }
    public String getSegment() { return segment; }
    public BigDecimal getMonthlyRevenue() { return monthlyRevenue; }
}
