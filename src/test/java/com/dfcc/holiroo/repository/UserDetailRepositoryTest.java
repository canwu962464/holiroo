package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.UserDetail;
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
public class UserDetailRepositoryTest {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Test
    @org.springframework.transaction.annotation.Transactional
    public void saveTest(){
        UserDetail user = new UserDetail();
        //user.setUserId(0);
        user.setUserName("Jack");
        user.setUserEmail("abcdefg@gmail.com");
        user.setUserPassword("1234");
        user.setUserBirthday("1998-5-9");
        user.setUserGender(0);
        user.setUserPhone("0456879772");
        user.setUserAdmin(1);
        user.setUserCredit(new BigDecimal("100"));

        UserDetail result = userDetailRepository.save(user);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){
        Optional<UserDetail> userOptional = userDetailRepository.findById("1");
        System.out.println(userOptional.get().toString());
    }
}