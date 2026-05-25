package dip.contracts;

import dip.domain.ClientProfile;

public interface ClientProfileRepository {
    ClientProfile findByDocument(String document);
}
