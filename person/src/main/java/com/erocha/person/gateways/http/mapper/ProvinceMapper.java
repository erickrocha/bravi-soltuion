package com.erocha.person.gateways.http.mapper;

import com.erocha.person.domains.Province;
import com.erocha.person.gateways.http.json.ProvinceTO;
import com.google.common.collect.Lists;

import java.util.List;

public class ProvinceMapper {

    public ProvinceTO toProvinceTO(Province p) {
        if (p != null)
            return ProvinceTO.builder().name(p.getName()).acronym(p.getAcronym()).build();
        return null;
    }

    public List<ProvinceTO> toProvinceTO(List<Province> provinces) {
        List<ProvinceTO> provinceTOS = Lists.newArrayList();
        provinces.forEach(p -> provinceTOS.add(toProvinceTO(p)));
        return provinceTOS;
    }

    public Province toProvince(ProvinceTO p) {
        if (p != null)
            return Province.builder().acronym(p.getAcronym()).name(p.getName()).build();
        return null;
    }
}
