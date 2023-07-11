package br.com.learn.controller

import br.com.learn.services.PersonService
import br.com.learn.util.MediaType.APPLICATION_JSON_VALUE
import br.com.learn.util.MediaType.APPLICATION_XML_VALUE
import br.com.learn.util.MediaType.APPLICATION_X_YAML_VALUE
import br.com.learn.vo.v1.PersonVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("person/")
class PersonController {

    @Autowired
    private lateinit var service: PersonService;

    @GetMapping(
            produces = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE]
    )
    fun findAll(): List<PersonVO> {
        return service.findAll();
    }

    @GetMapping("/{id}",
            produces = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE]
    )
    fun findById(@PathVariable("id") id: Long): PersonVO {
        return service.findById(id);
    }

    @PostMapping(
            consumes = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE],
            produces = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person);
    }

    @PutMapping(
            consumes = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE],
            produces = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE]
    )
    fun update(@RequestBody person: PersonVO): PersonVO {
        return service.update(person);
    }

    @DeleteMapping(path = ["/{id}"],
            consumes = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE],
            produces = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, APPLICATION_X_YAML_VALUE])
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}