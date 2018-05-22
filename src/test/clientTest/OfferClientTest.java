package clientTest;

import com.panoskakos.client.OfferClient;
import com.panoskakos.model.Offer;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class OfferClientTest extends TestCase
{



    @BeforeClass
    public static void init()
    {
        System.setProperty( "Mock-mode", "Y" );
    }


    @Test
    public void getAllOffers() throws Exception
    {

    }

    @Test
    public void postOffer() throws Exception
    {

    }

    @Test
    public void deleteOffer() throws Exception
    {

    }

    @Test
    public void getOffer() throws Exception
    {
        OfferClient offerClient = new OfferClient();
        Offer offer = offerClient.getOffer("testOffer1");
        System.out.println(offer);
        assertNotNull(offer);
    }


    @Test
    public void getOffers() throws Exception
    {
        OfferClient offerClient = new OfferClient();
        List<Offer> offers = offerClient.getOffers();
        System.out.println(offers);
        assertNotNull(offers);
    }
}