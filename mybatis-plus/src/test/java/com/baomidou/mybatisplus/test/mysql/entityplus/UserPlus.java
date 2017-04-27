
package com.baomidou.mybatisplus.test.mysql.entityplus;

import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.test.mysql.entity.PhoneNumber;

import java.io.Serializable;
import java.math.BigDecimal;


@TableName("user_plus")
public class UserPlus implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 100L;

    @TableId(value = "test_id")
    private Long id;

    @TableField(value = "user_name")
    private String userName;

    private Integer age;

    private BigDecimal price;

    @TableField(value = "test_type", validate = FieldStrategy.IGNORED)
    @TableLogic(value = "-2")
    private Integer testType;

    @Version
    private Integer version;

    @TableField(el = "phone, typeHandler=com.baomidou.mybatisplus.test.mysql.typehandler.PhoneTypeHandler")
    private PhoneNumber phone;

    public UserPlus() {

    }

    public UserPlus(String userName) {
        this.userName = userName;
    }

    public UserPlus(Integer testType) {
        this.testType = testType;
    }

    public UserPlus(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public UserPlus(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UserPlus(Long id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public UserPlus(Long id, String userName, Integer age, Integer testType) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.testType = testType;
    }

    public UserPlus(String userName, Integer age, Integer testType) {
        this.userName = userName;
        this.age = age;
        this.testType = testType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", price=" + price + ", testType=" + testType
                + ", phone=" + phone + "]";
    }
}
