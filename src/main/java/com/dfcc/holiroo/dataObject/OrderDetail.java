package com.dfcc.holiroo.dataObject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;

    private String orderStart;

    private String orderEnd;

    private BigDecimal orderPrice;

    private BigDecimal orderCleaningFee;

    private int orderTotalPeople;

    private String orderProperty;

    private String orderCustomer;

    private String orderHousehold;

    private int orderStatus;

    private Date createTime;

    private Date updateTime;
}
