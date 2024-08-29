package com.lab4dx.s03_jdbc_di.controller;

import com.lab4dx.s03_jdbc_di.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//스프링 컨테이너에는 컴포넌트 스캐너가 존재하는데...
//컴포넌트는(@Component)는 컨테이너에서 생성하고 주입할 수 있는 객체의 타입으로
//스프링 컨테이너의 컴포넌트 스캐너가 @Component를 자동으로 찾아서 객체로 만들고
//필요한 곳에서 사용하고 주입해준다. @Controller는 @Component의 자식이다.
@Controller
@RequestMapping("/customer") // "~~/customer/list or detail or update..."
public class CustomerController {
    @Autowired //컨테이너에 있는 객체를 주입하겠다.
    DataSource dataSource; //DB 접속한 Connection을 반환

    @GetMapping("/list.do")
    public void list(Model model) throws Exception { //오류발생시 500화면
        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customer");
        List<Customer> customers = new ArrayList<>();
        while (rs.next()) {
            Customer customer = new Customer();
            customers.setCustomerId(rs.getInt("customer_id"));
            customers.setCustomerName(rs.getString);

        }
    }
}
