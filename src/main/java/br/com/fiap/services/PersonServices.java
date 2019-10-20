package br.com.fiap.services;


import br.com.fiap.exception.ResourceNotFoundException;
import br.com.fiap.model.Person;
import br.com.fiap.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        return repository.save(person);
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Person update(Person person){
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);

    }
}
