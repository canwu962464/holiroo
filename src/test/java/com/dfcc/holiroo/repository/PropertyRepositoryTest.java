package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Property;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyRepositoryTest {
    @Autowired
    PropertyRepository propertyRepository;

    @Test
    public void saveTest(){
        Property property = new Property();
        property.setPropertyName("Best House!");
        property.setPropertyAddress("35 Bill Avenue");
        property.setPropertyPostcode(2055);
        property.setPropertyBedroom(4);
        property.setPropertyBed(4);
        property.setPropertyToilet(3);
        property.setPropertyCarpark(6);
        property.setPropertyCapacity(6);
        property.setPropertyDescription("This is a luxury house for most 6 pp");
        property.setPropertyMark(new BigDecimal(0));
        property.setPropertyMarkPeople(0);
        property.setPropertyPrice(new BigDecimal("1500"));
        property.setPropertyCleaningFee(new BigDecimal("150"));
        property.setPropertyOwner("123345345");
        property.setPropertyType("house");
        property.setPropertyFreeCancel(0);
        property.setPropertyAvailable(0);
        property.setPropertyAdvertised(0);
        property.setPropertyAutoConfirmed(1);

        Property result = propertyRepository.save(property);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOneTest(){
        Optional<Property> test = propertyRepository.findById("1");
        Assert.assertNotNull(test.get());
        System.out.println(test.get().toString());
    }

}