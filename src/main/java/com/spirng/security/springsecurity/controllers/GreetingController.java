package com.spirng.security.springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/", method = RequestMethod.GET)
public class GreetingController {
    
    @GetMapping(path = "/greeting")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok().body("Hello dear!");
    }

    @GetMapping(path = "/goodbeye")
    public ResponseEntity<String> sayGoodBeye() {
        return ResponseEntity.ok().body("Good beye dear !");
    }
}
