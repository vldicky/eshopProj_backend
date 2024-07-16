package com.fsse2406.eshopproject.api.user;

//import com.fsse2406.eshopproject.data.person.data.request.CreatePersonRequestData;
//import com.fsse2406.eshopproject.data.person.data.response.PersonResponseData;
//import com.fsse2406.eshopproject.data.person.dto.request.CreatePersonRequestDto;
//import com.fsse2406.eshopproject.data.person.dto.response.PersonResponseDto;
//import com.fsse2406.eshopproject.service.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping
//public class PersonApi {
//
//    private final PersonService personService;
//
//    @Autowired
//    public PersonApi(PersonService personService){
//        this.personService = personService;
//    }
//
//    @PostMapping
//    public PersonResponseDto createPerson(@RequestBody CreatePersonRequestDto createPersonRequestDto) {
//
////    Lv3
//        return new PersonResponseDto(personService.createPerson(new CreatePersonRequestData(createPersonRequestDto)));
//    }
//
//}
