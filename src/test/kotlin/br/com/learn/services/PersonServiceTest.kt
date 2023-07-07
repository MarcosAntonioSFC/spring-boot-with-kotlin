package br.com.learn.services

import org.junit.jupiter.api.Test

class PersonServiceTest {


    @Test
    fun abstractTest() {
        var service: PersonService = PersonService();

        service.getEntityType();

    }
}