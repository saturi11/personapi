package gabriel.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gabriel.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    

   

    
}
