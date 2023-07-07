package br.com.learn.services

import br.com.learn.exceptions.ResourceNotFoundException
import br.com.learn.mapper.DozerMapper
import br.com.learn.model.Person
import br.com.learn.repository.PersonRepository
import br.com.learn.vo.v1.PersonVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService : AbstractService<Person, PersonVO>() {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people")
        return toVOs(repository.findAll());
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding a person by id: $id")
        return toVO(repository.findById(id).orElseThrow { throw ResourceNotFoundException("Person Not Found for ID: $id") });
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating a Person: $person")
        val personValue = DozerMapper.parseObject(person, Person::class.java);
        return toVO(repository.saveAndFlush(personValue));
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Updating a Person: $person")
        val entity = findById(person.id);

        entity.firstName = person.firstName;
        entity.lastName = person.lastName;
        entity.address = person.address;
        entity.gender = person.gender;

        return toVO(repository.saveAndFlush(toEntity(entity)));
    }

    fun delete(id: Long) {
        logger.info("Deleting a Person with ID: $id")
        repository.delete(toEntity(findById(id)));
    }
}