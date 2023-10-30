package tn.esb.bi2.ecommerceApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi2.ecommerceApi.Domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
