package com.dev.sec.ops.learn.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MyService {
    public List<Employee> getEmpDetails()
    {
        return Arrays.asList(
                new Employee(101,"sahil",100000f),
                new Employee(102,"Sunil",100000f),
                new Employee(103,"Anil",100000f));
    }

}



