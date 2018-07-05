package com.erocha.person.gateways.http;

import com.erocha.person.domains.Contact;
import com.erocha.person.domains.Person;
import com.erocha.person.exception.BusinessException;
import com.erocha.person.gateways.http.json.ContactTO;
import com.erocha.person.gateways.http.json.PersonTO;
import com.erocha.person.gateways.http.mapper.ContactMapper;
import com.erocha.person.gateways.http.mapper.PersonMapper;
import com.erocha.person.usecases.*;
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

    @Autowired
    private AddContact addContact;

    @Autowired
    private RemoveContact removeContact;

    @GetMapping("/persons")
    @ApiOperation(value = "Get All Persons", response = PersonTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entities found"),
    })
    public Page<PersonTO> gets(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "identityDocument", required = false) String identityDocument,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "perPage", defaultValue = "5") Integer perPage,
                               @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                               @RequestParam(value = "sortBy", required = false) String sortBy) {

        PageRequest pageRequest = PageRequest.of(page, perPage, Sort.Direction.valueOf(direction), sortBy);
        Page<Person> personPage = getPerson.execute(name, identityDocument, pageRequest);
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


    @PatchMapping("/persons/{personId}/contacts")
    @ApiOperation(value = "Add Contact to a Person")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public void addContact(@PathVariable("personId") Integer personId, @Valid @RequestBody ContactTO contactTO) {
        ContactMapper mapper = new ContactMapper();
        Contact contact = mapper.toContact(contactTO);
        addContact.execute(personId, contact);
    }

    @DeleteMapping("/persons/{personId}/contacts/{contactId}")
    @ApiOperation(value = "Remove a Contact from a Person")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public void addContact(@PathVariable("personId") Integer personId, @PathVariable("contactId") Integer contactId) {
        removeContact.execute(personId, contactId);
    }

}
