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
public class Remark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String remarkId;

    private String propertyId;

    private int remarkMark;

    private String remarkContent;

    private String remarkCustomerId;

    private Date createTime;

    private Date updateTime;
}
