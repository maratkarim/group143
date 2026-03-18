package kz.bitlab.service.repository;

import kz.bitlab.service.model.AppleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleProductRepository extends JpaRepository<AppleProduct, Long> {
}
