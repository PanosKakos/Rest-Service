package com.panoskakos.repository;

import com.panoskakos.mock.TestOfferResourceStub;

public class OfferResourceStubFactory
{



    public static Object getOfferResourceStub() throws IllegalAccessException, InstantiationException
    {
        synchronized (OfferResourceStubFactory.class)
        {
            Class daoClass = null;
            if (testMode()) {
                daoClass = TestOfferResourceStub.class;

            }
            else
            {
                daoClass = OfferResourceStub.class;
            }
            return daoClass.newInstance();
        }
    }


    public static boolean testMode()
    {
        return "Y".equalsIgnoreCase( System.getProperty( "Mock-mode" ) );
    }
}

