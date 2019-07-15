package ooc.finals.nameconverter;

import ooc.finals.nameconverter.formats.Format;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public String convert(FormatSpecification spec){
        Format formatter = FormatFactory.getFormat(spec.getFormat());
        if(formatter == null){
            return null;
        }
        return formatter.apply(spec);
    }
}
