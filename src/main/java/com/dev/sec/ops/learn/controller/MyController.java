package com.dev.sec.ops.learn.controller;

import com.dev.sec.ops.learn.service.Employee;
import com.dev.sec.ops.learn.service.MyService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private MyService myservice;
    @GetMapping("/employee/employee-details")
    public List<Employee> getEmpDetails()
    {
     return  myservice.getEmpDetails();
    }
}
