package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Picture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PictureRepositoryTest {
    @Autowired
    PictureRepository pictureRepository;

    @Test
    public void saveTest(){
        Picture picture = new Picture();
        picture.setPictureSource("static/1.png");
        picture.setTargetProperty("1");

        Picture result = pictureRepository.save(picture);
        Assert.assertNotNull(result);
    }

}