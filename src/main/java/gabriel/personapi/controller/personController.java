package gabriel.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gabriel.personapi.dto.MessageResponseDTO;
import gabriel.personapi.entity.Person;
import gabriel.personapi.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1/person")
public class personController {

    private final PersonRepository personRepository;

    @Autowired
    public personController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
       Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
        .message("Created person with ID " + savedPerson.getId())
        .build();
    }

}
