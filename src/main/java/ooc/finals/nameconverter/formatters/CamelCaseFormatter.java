package ooc.finals.nameconverter.formatters;


import ooc.finals.nameconverter.FormatSpecification;
import org.apache.commons.lang3.StringUtils;

public class CamelCaseFormatter implements Formatter {

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
