package com.example.todoapi.repositry.sample;

import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositry {

    public SampleRecord select(){
        return new SampleRecord("Hello");
    }
}
