package com.capitole.ecommerce.Repository;

import com.capitole.ecommerce.Entity.PricesDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ECommerceRepository extends JpaRepository<PricesDao, Long> {

    // this is to find data with the ProductId, the Brand ID and the application date between StartDate and End Date.
    List<PricesDao> findAllByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(Integer productId, Integer brandId, LocalDateTime applicationDate, LocalDateTime applicationDate1);

}
