package ooc.finals.nameconverter.formats;


import ooc.finals.nameconverter.FormatSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.support.FormattingConversionService;

import java.util.List;

public class CamelCaseFormat implements Format  {

    @Override
    public String apply(FormatSpecification spec) {
        String name = spec.getName();
        String[] words = StringUtils.splitByCharacterTypeCamelCase(name);
        words[0] = StringUtils.lowerCase(words[0]);
        for(int i=1; i<words.length; i++){
            StringUtils.capitalize(words[i]);
        }
        return StringUtils.join(words);
    }
}
