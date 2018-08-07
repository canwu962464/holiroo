package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Wishlist;
import com.dfcc.holiroo.util.KeyGenerateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.Key;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WishlistRepositoryTest {

    @Autowired
    WishlistRepository wishlistRepository;

    @Test
    public void saveTest(){
        Wishlist wishlist = new Wishlist();
        wishlist.setWishId(KeyGenerateUtil.genUniqueKey());
        wishlist.setUserId("10000");
        wishlist.setWishProperty("23454435");

        Wishlist result = wishlistRepository.save(wishlist);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){

        Optional<Wishlist> test = wishlistRepository.findById("1");
        Assert.assertNotNull(test.get());
        System.out.println(test.get());
    }

}