package com.dfcc.holiroo.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pictureId;

    private String pictureSource;

    private String targetProperty;

    private Date createTime;

    private Date updateTime;
}
