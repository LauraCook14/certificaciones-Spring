package com.example.certificaciones.endPoint;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/certification")

public class Certificaciones {

    @GetMapping("/get")

    public String get (){
        return "Salu2 cordiales ;V";
    }

    @GetMapping("/insertcertification")
    public String insertCertification (@RequestParam String name){
        List<String> listName = new ArrayList<>();

        listName.add("Juan");
        listName.add("Beto");
        listName.add(name);

        return listName.toString();
    }
}
