package com.erocha.person.gateways.http;

import com.erocha.person.gateways.http.json.ProvinceTO;
import com.erocha.person.gateways.http.mapper.ProvinceMapper;
import com.erocha.person.usecases.GetResources;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Rest api for Provinces operations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResourcesController {

    @Autowired
    private GetResources getResources;

    @GetMapping("/provinces")
    @ApiOperation(value = "Get All provinces", response = ProvinceTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entity created"),
    })
    public List<ProvinceTO> findAllProvinces() {
        ProvinceMapper mapper = new ProvinceMapper();
        return mapper.toProvinceTO(getResources.getAllProvinces());
    }

}
