package tn.esb.bi2.ecommerceApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi2.ecommerceApi.Domains.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
