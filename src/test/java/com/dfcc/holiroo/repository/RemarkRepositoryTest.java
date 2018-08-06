package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Remark;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RemarkRepositoryTest {

    @Autowired
    RemarkRepository remarkRepository;

    @Test
    public void saveTest(){
        Remark remark = new Remark();
        remark.setPropertyId("10000");
        remark.setRemarkMark(5);
        remark.setRemarkContent("This is perfect. I will recommend this for you!");
        remark.setRemarkCustomerId("2342342345");

        Remark result = remarkRepository.save(remark);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){
        Optional<Remark> test = remarkRepository.findById("1");
        Assert.assertNotNull(test.get());
        System.out.println(test.get());
    }

}