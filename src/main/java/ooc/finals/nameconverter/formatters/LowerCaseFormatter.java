package ooc.finals.nameconverter.formatters;


import ooc.finals.nameconverter.FormatSpecification;
import org.apache.commons.lang3.StringUtils;

public class LowerCaseFormatter implements Formatter {

    @Override
    public String apply(FormatSpecification spec) {
        String name = spec.getName();
        return StringUtils.lowerCase(name);
    }
}
