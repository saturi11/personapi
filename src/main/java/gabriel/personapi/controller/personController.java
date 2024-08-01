package gabriel.personapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gabriel.personapi.dto.MessageResponseDTO;
import gabriel.personapi.dto.request.PersonDTO;
import gabriel.personapi.service.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class personController {
    private PersonService personService;

    @Autowired
    public personController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
    
    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public  PersonDTO FindById(@PathVariable Long id) {
        return personService.FindById(id);
    }

}
