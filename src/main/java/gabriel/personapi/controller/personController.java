package gabriel.personapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class personController {
    
    @RequestMapping
    public String getPerson(){
        return "API Test!";
    }

}
