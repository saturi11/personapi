package gabriel.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import gabriel.personapi.dto.request.PersonDTO;
import gabriel.personapi.entity.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
 
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}
