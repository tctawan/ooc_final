package ooc.finals.nameconverter.formats;


import ooc.finals.nameconverter.FormatSpecification;
import org.apache.commons.lang3.StringUtils;

public class OracleFriendlyWithPrefixFormat implements Format  {

    @Override
    public String apply(FormatSpecification spec) {
        String name = spec.getName();
        String[] words = StringUtils.splitByCharacterTypeCamelCase(name);
        for (int i =0;i<words.length; i++) {
            words[i] = StringUtils.upperCase(words[i]);
        }
        String formatted = StringUtils.join(words,"_");
        if(spec.getType().equals("class")){
            formatted = "TBL_" + formatted;
        }
        return formatted;
    }
}
