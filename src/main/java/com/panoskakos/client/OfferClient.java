package com.panoskakos.client;

import com.panoskakos.model.Offer;
import com.panoskakos.repository.OfferRepository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class OfferClient
{

    private Client client =  ClientBuilder.newClient();;

    public OfferClient()
    {
        client = ClientBuilder.newClient();
    }


    public Offer getOffer(String description)
    {
        WebTarget target = client.target("http://localhost:8080/webapi/myresource/");
        Response response = target.path("offer/" + description).request(MediaType.APPLICATION_JSON).get(Response.class );

        if(response.getStatus() != 200)
        {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }
        return response.readEntity(Offer.class);
    }


    public List<Offer> getOffers()
    {
        WebTarget target = client.target("http://localhost:8080/webapi/myresource");
        List<Offer> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Offer>>(){});
        return response;
    }

    public Response postOffer()
    {
        //to do
     return  null;
    }

    public Response deleteOffer(){
        //to do
        return null;
    }

}
