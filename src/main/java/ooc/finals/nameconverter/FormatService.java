package ooc.finals.nameconverter;

import ooc.finals.nameconverter.formatters.Formatter;
import org.springframework.stereotype.Service;

@Service
public class FormatService {

    public String convert(FormatSpecification spec){
        Formatter formatter = FormatterFactory.getFormat(spec.getFormat());
        if(formatter == null){
            return null;
        }
        return formatter.apply(spec);
    }
}
