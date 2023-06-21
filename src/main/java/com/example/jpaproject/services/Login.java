package com.example.jpaproject.services;

import com.example.jpaproject.entities.Credentional;
import org.springframework.stereotype.Service;

@Service
public abstract class Login {

    public abstract String login(Credentional credentional);

}
