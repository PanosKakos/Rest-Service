package com.panoskakos.repository;

import com.panoskakos.model.Offer;

import javax.ws.rs.core.Response;
import java.util.List;

public interface OfferResourceStubInterface
{
    public List<Offer> findAllOffers();

    public Response delete(String description);

    public Offer createOffer(Offer offer);

    public Offer findOffer(String description);
}

