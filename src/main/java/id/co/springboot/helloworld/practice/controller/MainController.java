package id.co.springboot.helloworld.practice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("hello-world")
public class MainController {

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> helloWorld(HttpServletRequest request,
                                             HttpServletResponse response,
                                             @RequestParam(name = "name") String name,
                                             @RequestParam(name = "phone") String phoneNumber) {

        log.info("{} Request | name {} | phone number {} ", request.getPathInfo(), name, phoneNumber);

        return ResponseEntity.ok("Hello " + name);
    }
}
