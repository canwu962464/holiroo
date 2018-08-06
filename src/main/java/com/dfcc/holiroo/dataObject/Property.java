package com.dfcc.holiroo.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String propertyId;

    private String propertyName;

    private String propertyAddress;

    private int propertyPostcode;

    private int propertyBedroom;

    private int propertyBed;

    private int propertyToilet;

    private int propertyCarpark;

    private int propertyCapacity;

    private String propertyDescription;

    private BigDecimal propertyMark;

    private int propertyMarkPeople;

    private BigDecimal propertyPrice;

    private BigDecimal propertyCleaningFee;

    private String propertyOwner;

    private String propertyType;

    private  int propertyFreeCancel; //0 for free cancel, 1 for not

    private int propertyAvailable; //0 for available, 1 for not available

    private int propertyAdvertised; //0 for top, 1 for not advertised

    private int propertyAutoConfirmed; //0 for auto confirmed, 1 for not auto confirmed

    private Date createTime;

    private Date updateTime;

}
