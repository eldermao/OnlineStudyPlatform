package com.example.springboottest.service;

import com.example.springboottest.module.s_c;
import org.springframework.stereotype.Service;

@Service
public interface s_cService {
    s_c findS_c(Integer courseid, Integer studentid);
}
