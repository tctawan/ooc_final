package ooc.finals.nameconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class Controller {

    private ConvertService convertService;

    @Autowired
    Controller(ConvertService convertService){
        this.convertService = convertService;
    }

    @PostMapping("/convert")
    ResponseEntity convert(@RequestBody FormatSpecification spec){
        String result = convertService.convert(spec);
        if(result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(result);
    }
}