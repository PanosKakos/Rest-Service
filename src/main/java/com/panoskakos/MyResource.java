package com.panoskakos;

import com.panoskakos.model.Offer;
import com.panoskakos.repository.OfferResourceStubFactory;
import com.panoskakos.repository.OfferResourceStubInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {




    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllOffers()
    {
        List<Offer> offers = null;
        try {
            offers = ((OfferResourceStubInterface) OfferResourceStubFactory.getOfferResourceStub()).findAllOffers();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        if(offers.size() == 0)
        {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(new GenericEntity<List<Offer>>(offers){} ).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postOffer(Offer offer , @Context UriInfo uriInfo) throws InstantiationException, IllegalAccessException {
        ((OfferResourceStubInterface)OfferResourceStubFactory.getOfferResourceStub()).createOffer(offer);
        URI createdURI = uriInfo.getBaseUriBuilder().path("/myresource/offer/" + offer.getDescription()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/delete/{description}")
    public Response deleteOffer(@PathParam("description") String description) throws InstantiationException, IllegalAccessException {
        return ((OfferResourceStubInterface)OfferResourceStubFactory.getOfferResourceStub()).delete(description);
    }

    @GET
    @Path("/offer/{description}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffer(@PathParam("description") String description) throws InstantiationException, IllegalAccessException {
        Offer offer = ((OfferResourceStubInterface) OfferResourceStubFactory.getOfferResourceStub()).findOffer(description);
        if(offer == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("Offer not Found ").build();
        }
        if(offer.isExpired())
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("Offer has expired ").build();
        }
        else
        {
            return Response.ok(offer).build();
        }
    }


}