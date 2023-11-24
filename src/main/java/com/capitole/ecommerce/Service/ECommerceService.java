package com.capitole.ecommerce.Service;

import com.capitole.ecommerce.Entity.PricesDao;
import com.capitole.ecommerce.Model.FinalPriceRequest;
import com.capitole.ecommerce.Model.FinalPriceResponse;
import com.capitole.ecommerce.Repository.ECommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ECommerceService {

    private final ECommerceRepository eCommerceRepository;

    @Autowired
    public ECommerceService(ECommerceRepository eCommerceRepository) {
        this.eCommerceRepository = eCommerceRepository;
    }

    public FinalPriceResponse getProductPrice(FinalPriceRequest finalPriceRequest){
        List<PricesDao>  prices = eCommerceRepository.findAllByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(finalPriceRequest.getProductId(),
                finalPriceRequest.getBrandId(), finalPriceRequest.getApplicationDate(), finalPriceRequest.getApplicationDate());

        // i need to filter by priority if i receive more than 1
        Optional<PricesDao> priceFiltered = getItemWithHighestPriority(prices);

        // if the list is empty i return null
        return priceFiltered.map(pricesDao -> FinalPriceResponse.builder().finalPrice(pricesDao.getPrice())
                .productId(pricesDao.getProductId()).priceList(pricesDao.getPriceListId())
                .applicationDate(finalPriceRequest.getApplicationDate()).startDate(pricesDao.getStartDate())
                .endDate(pricesDao.getEndDate()).build()).orElse(null);


    }

    public Optional<PricesDao> getItemWithHighestPriority(List<PricesDao> pricesList) {

        // i get the item with the highest priority using stream and comparator.
        return pricesList.stream()
                .max(Comparator.comparingInt(PricesDao::getPriority));
    }
}
