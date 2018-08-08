package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Request;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RequestRepositoryTest {
    @Autowired
    RequestRepository requestRepository;

    @Test
    public void saveTest(){
        Request request = new Request();
        request.setRequestUserId("10000");
        request.setRequestPostcode(2055);
        request.setRequestBedroom("5-6");
        request.setRequestBed("3-4");
        request.setRequestToilet("3-7");
        request.setRequestCarpark("5-6");
        request.setRequestCapacity("6-8");
        request.setRequestStart("2018-10-9");
        request.setRequestEnd("2018-10-18");
        request.setRequestDescription("I want a big big house");
        request.setRequestPropertyType("House");
        request.setRequestPrice("1000-1500");

        Request result = requestRepository.save(request);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOneTest(){
        Optional<Request> test = requestRepository.findById("1");
        Assert.assertNotNull(test.get());
        System.out.println(test.get());
    }

}