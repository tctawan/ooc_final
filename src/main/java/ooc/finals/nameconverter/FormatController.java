package ooc.finals.nameconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatController {

    private FormatService formatService;

    @Autowired
    FormatController(FormatService formatService){
        this.formatService = formatService;
    }

    @PostMapping("/convert")
    ResponseEntity convert(@RequestBody FormatSpecification spec){
        String result = formatService.convert(spec);
        if(result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(result);
    }
}