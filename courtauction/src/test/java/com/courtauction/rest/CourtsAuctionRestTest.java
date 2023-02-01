package com.courtauction.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourtsAuctionRestTest {

    @Autowired
    private CourtAuctionRest courtAuctionRest;

    @Test
    void fetchList() {
        courtAuctionRest.fetchList();
    }

    @Test
    void fetchCourts() {
        courtAuctionRest.fetchCourts();
    }
}
