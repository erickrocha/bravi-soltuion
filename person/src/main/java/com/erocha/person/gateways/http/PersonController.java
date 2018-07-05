package com.erocha.person.gateways.http;

import com.erocha.person.domains.Person;
import com.erocha.person.gateways.http.json.PersonTO;
import com.erocha.person.gateways.http.mapper.PersonMapper;
import com.erocha.person.usecases.AddPerson;
import com.erocha.person.usecases.GetPerson;
import com.erocha.person.usecases.RemovePerson;
import com.erocha.person.usecases.UpdatePerson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Rest api for Person operations", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    private GetPerson getPerson;

    @Autowired
    private AddPerson addPerson;

    @Autowired
    private RemovePerson removePerson;

    @Autowired
    private UpdatePerson updatePerson;

    @GetMapping("/persons")
    @ApiOperation(value = "Get All Persons", response = PersonTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entities found"),
    })
    public Page<PersonTO> gets(@RequestParam(value = "name",required = false) String name,
                     @RequestParam(value = "identityDocument",required = false) String identityDocument,
                     @RequestParam(value = "email",required = false) String email,
                     @RequestParam(value = "birthDate",required = false) LocalDate birthDate,
                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                     @RequestParam(value = "perPage", defaultValue = "5") Integer perPage,
                     @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                     @RequestParam(value = "sortBy", required = false) String sortBy) {

        PageRequest pageRequest = PageRequest.of(page,perPage,Sort.Direction.valueOf(direction),sortBy);
        Page<Person> personPage = getPerson.execute(name,identityDocument,email,birthDate,pageRequest);
        PersonMapper mapper = new PersonMapper();

        Page<PersonTO> personTOS = personPage.map(person -> mapper.toPersonTO(person));
        return personTOS;
    }


    @GetMapping("/persons/{id}")
    @ApiOperation(value = "Get Person by id", response = PersonTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entity found"),
    })
    public PersonTO get(@PathVariable("id") Integer id) {
        PersonMapper mapper = new PersonMapper();
        return mapper.toPersonTO(getPerson.execute(id));
    }

    @PostMapping(value = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Persist new Person", response = PersonTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Entity created"),
            @ApiResponse(code = 422, message = "unprocessable entity")
    })
    public PersonTO add(@Valid @RequestBody PersonTO newPerson) {
        PersonMapper mapper = new PersonMapper();
        Person person = mapper.toPerson(newPerson);
        return mapper.toPersonTO(addPerson.execute(person));
    }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a Person")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Entity created"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public void delete(@PathVariable("id") Integer id) {
        removePerson.execute(id);
    }

}
