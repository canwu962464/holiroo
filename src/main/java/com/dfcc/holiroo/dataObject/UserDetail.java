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
@Data
@DynamicUpdate
public class UserDetail {

    @Id
    private String userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userBirthday;

    private String userGender;

    private String userPhone;

    private int userAdmin; //0 for admin, 1 for normal user

    private BigDecimal userCredit;

    private Date createTime;

    private Date updateTime;


}
