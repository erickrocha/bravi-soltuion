package com.erocha.person.gateways.http.mapper;

import com.erocha.person.domains.Address;
import com.erocha.person.gateways.http.json.AddressTO;

public class AddressMapper {

    private ProvinceMapper provinceMapper;

    public AddressMapper(ProvinceMapper provinceMapper) {
        this.provinceMapper = provinceMapper;
    }

    public AddressMapper() {
        this(new ProvinceMapper());
    }


    public AddressTO toAddressTO(Address a) {
        if (a != null) {
            return AddressTO.builder()
                    .street(a.getStreet())
                    .neighborhood(a.getNeighborhood())
                    .city(a.getCity())
                    .addressNumber(a.getAddressNumber())
                    .zipCode(a.getZipCode())
                    .complement(a.getComplement())
                    .province(a.getProvince())
                    .build();
        }
        return null;
    }

    public Address toAddress(AddressTO a) {
        if (a != null) {
            return Address.builder()
                    .street(a.getStreet())
                    .neighborhood(a.getNeighborhood())
                    .city(a.getCity())
                    .addressNumber(a.getAddressNumber())
                    .zipCode(a.getZipCode())
                    .complement(a.getComplement())
                    .province(a.getProvince())
                    .build();
        }
        return null;
    }
}
