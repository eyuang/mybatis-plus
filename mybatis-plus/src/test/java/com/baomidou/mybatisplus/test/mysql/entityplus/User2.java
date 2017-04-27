/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.test.mysql.entityplus;

import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.FieldStrategy;

import java.math.BigDecimal;

@TableName(resultMap = "userMap")
public class User2 {

    @TableId(value = "test_id")
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal price;

    @TableField(value = "test_type", validate = FieldStrategy.IGNORED)
    @TableLogic(value = "-2") // 该注解为了测试逻辑删除、这里设置 -2 为删除值
    private Integer testType;
    private String desc = "默认描述";

    @Version
    private Integer version;

    public User2() {

    }

    public User2(String name) {
        this.name = name;
    }

    public User2(Integer testType) {
        this.testType = testType;
    }

    public User2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User2(Long id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public User2(Long id, String name, Integer age, Integer testType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.testType = testType;
    }

    public User2(String name, Integer age, Integer testType) {
        this.name = name;
        this.age = age;
        this.testType = testType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", price=" + price + ", testType=" + testType
                + ", desc=" + desc + "]";
    }
}
