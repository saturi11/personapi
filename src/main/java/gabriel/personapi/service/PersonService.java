package gabriel.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.personapi.dto.MessageResponseDTO;
import gabriel.personapi.dto.request.PersonDTO;
import gabriel.personapi.entity.Person;
import gabriel.personapi.mapper.PersonMapper;
import gabriel.personapi.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found with ID " + id));
        return personMapper.toDTO(person);
    }

    public PersonDTO updateById(Long id, @Valid PersonDTO personDTO) {
        Person personToUpdate = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found with ID " + id));
        Person updatedPerson = personMapper.toModel(personDTO);
        updatedPerson.setId(id); // Ensure ID is preserved
        updatedPerson = personRepository.save(updatedPerson);
        return personMapper.toDTO(updatedPerson);
    }

    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Person not found with ID " + id);
        }
        personRepository.deleteById(id);
    }
}
