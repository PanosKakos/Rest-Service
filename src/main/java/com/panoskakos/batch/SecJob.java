package com.panoskakos.batch;

import com.panoskakos.model.Offer;
import com.panoskakos.repository.OfferRepository;
import com.panoskakos.utilities.DateUtil;

import java.util.List;

public class SecJob implements Runnable {

   private List<Offer> offers = OfferRepository.getOffers();

    @Override
    public void run() {
        for(Offer offer : offers )
        {
            if(DateUtil.dateUtils( offer.getExpiryDate()))
            {
                offer.setExpired(true);
            }
        }
    }
}
