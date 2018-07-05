package com.erocha.person.config.bootstrap;

import com.erocha.person.config.bootstrap.service.DatabasePopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class DatabasePopulator {

    @Autowired
    private DatabasePopulatorService service;

    @PostConstruct
    public void init() {
        service.execute();
    }
}
