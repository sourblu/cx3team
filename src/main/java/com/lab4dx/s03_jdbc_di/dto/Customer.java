package com.lab4dx.s03_jdbc_di.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter //컴파일할 때 get set을 정의(lombok)
@ToString
public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

}
