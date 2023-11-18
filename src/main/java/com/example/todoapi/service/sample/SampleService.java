package com.example.todoapi.service.sample;

import com.example.todoapi.repositry.sample.SampleRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepositry repositry;

    public SampleEntity find() {
        var record = repositry.select();
        return new SampleEntity(record.getContent());
    }
}
