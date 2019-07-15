package ooc.finals.nameconverter.formats;


import ooc.finals.nameconverter.FormatSpecification;
import org.apache.commons.lang3.StringUtils;

public class LowerCaseFormat implements Format  {

    @Override
    public String apply(FormatSpecification spec) {
        String name = spec.getName();
        return StringUtils.lowerCase(name);
    }
}
