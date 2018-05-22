package com.panoskakos.repository;

import com.panoskakos.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferRepository
{

    private static final List<Offer> offers = new ArrayList<>();

    public static List<Offer> getOffers() {
        return offers;
    }
}

