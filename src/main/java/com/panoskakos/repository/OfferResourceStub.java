package com.panoskakos.repository;

import com.panoskakos.model.Offer;

import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OfferResourceStub implements OfferResourceStubInterface {



    public List<Offer> findAllOffers()
    {
        return  OfferRepository.getOffers();
    }


    public Response delete(String description)
    {

        for (Offer offer :  OfferRepository.getOffers())
        {
            if (offer.getDescription().equals(description) && !offer.isExpired())
            {
                OfferRepository.getOffers().remove(offer);
                return Response.ok().entity("Offer succesfully deleted").build();
            }
            else if (offer.getDescription().equals(description) && offer.isExpired())
            {
                return Response.status(Response.Status.BAD_REQUEST).entity("Offer has expired").build();
            }
            else
            {
                return Response.status(Response.Status.NOT_FOUND).entity("Offer not found").build();
            }
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("List of Offers is empty").build();
    }


    public Offer createOffer(Offer offer)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        offer.setDateOffered(LocalDateTime.now().format(formatter).toString());
        OfferRepository.getOffers().add(offer);
        return offer;
    }



    public Offer findOffer(String description)
    {
        for(Offer offer : OfferRepository.getOffers())
        {
            if(description.equals(offer.getDescription()))
            {
                return offer;
            }
        }
        return  null;
    }
}

