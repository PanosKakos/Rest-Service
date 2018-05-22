package com.panoskakos.mock;

import com.panoskakos.model.Offer;
import com.panoskakos.repository.OfferResourceStubInterface;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class TestOfferResourceStub implements OfferResourceStubInterface
{
    List<Offer> testOfferList = new ArrayList<>();
    public TestOfferResourceStub() {

        Offer testOffer1 = new Offer();
        testOffer1.setDescription("testOffer1");
        testOffer1.setPrice(10);
        testOffer1.setDateOffered("21/5/2018 11:50:10");
        testOffer1.setExpired(false);


        Offer testOffer2 = new Offer();
        testOffer2.setDescription("testOffer2");
        testOffer2.setPrice(10);
        testOffer2.setDateOffered("21/5/2018 10:50:10");
        testOffer2.setExpired(false);

        testOfferList.add(testOffer1);
        testOfferList.add(testOffer2);
    }

    @Override
    public List<Offer> findAllOffers()
    {
        return testOfferList;
    }

    @Override
    public Response delete(String description) { return null;}

    @Override
    public Offer createOffer(Offer offer)
    { return  null;}

    @Override
    public Offer findOffer(String description) {

        for(Offer offer : testOfferList)
        {
            if(description.equals(offer.getDescription()))
            {
                return offer;
            }
        }
        return  null;
    }
}
