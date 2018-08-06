package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderStart("2018-9-9");
        orderDetail.setOrderEnd("2018-9-20");
        orderDetail.setOrderPrice(new BigDecimal("15"));
        orderDetail.setOrderCleaningFee(new BigDecimal("1"));
        orderDetail.setOrderTotalPeople(4);
        orderDetail.setOrderProperty("1435234");
        orderDetail.setOrderCustomer("1234134");
        orderDetail.setOrderHousehold("242344");
        orderDetail.setOrderStatus(0);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){

        Optional<OrderDetail> order = orderDetailRepository.findById("1");
        Assert.assertNotNull(order.get());
        System.out.println(order.toString());

    }
}