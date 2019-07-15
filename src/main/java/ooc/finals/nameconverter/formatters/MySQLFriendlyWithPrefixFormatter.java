package ooc.finals.nameconverter.formatters;


import ooc.finals.nameconverter.FormatSpecification;
import org.apache.commons.lang3.StringUtils;

public class MySQLFriendlyWithPrefixFormatter implements Formatter {

    @Override
    public String apply(FormatSpecification spec) {
        String name = spec.getName();
        String[] words = StringUtils.splitByCharacterTypeCamelCase(name);
        for (int i =0;i<words.length; i++) {
            words[i] = StringUtils.lowerCase(words[i]);
        }
        String formatted = StringUtils.join(words,"_");
        if(spec.getType().equals("class")){
            formatted = "tbl_" + formatted;
        }
        return formatted;
    }
}
