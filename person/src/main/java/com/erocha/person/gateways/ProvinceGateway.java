package com.erocha.person.gateways;

import com.erocha.person.domains.Province;
import com.erocha.person.gateways.repository.ProvinceRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProvinceGateway {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> findAll() {
        return Lists.newArrayList(provinceRepository.findAll());
    }

    public Optional<Province> findByAcronym(String acronym) {
        return provinceRepository.findById(acronym);
    }

}
