package com.erocha.person.usecases;

import com.erocha.person.domains.Province;
import com.erocha.person.gateways.ProvinceGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetResources {

    @Autowired
    private ProvinceGateway provinceGateway;

    public List<Province> getAllProvinces() {
        return provinceGateway.findAll();
    }
}
