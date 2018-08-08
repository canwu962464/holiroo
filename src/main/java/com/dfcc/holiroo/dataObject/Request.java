package com.dfcc.holiroo.dataObject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String requestId;

    private String requestUserId;

    private int requestPostcode;

    private String requestBedroom;

    private String requestBed;

    private String requestToilet;

    private String requestCarpark;

    private String requestCapacity;

    private String requestDescription;

    private String requestPropertyType;

    private String requestPrice;

    private String requestStart;

    private String requestEnd;

    private Date createTime;

    private Date updateTime;
}
