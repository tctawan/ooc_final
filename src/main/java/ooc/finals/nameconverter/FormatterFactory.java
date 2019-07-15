package ooc.finals.nameconverter;

import ooc.finals.nameconverter.formatters.*;

import java.util.HashMap;
import java.util.Map;

public class FormatterFactory {
    static Map<String, Formatter> formatMap = new HashMap<>();
    static {
        formatMap.put("camelCase" , new CamelCaseFormatter());
        formatMap.put("snake_case" , new SnakeCaseFormatter());
        formatMap.put("lowercase" , new LowerCaseFormatter());
        formatMap.put("UPPERCASE" , new UpperCaseFormatter());
        formatMap.put("kebab-case" , new KebabCaseFormatter());
        formatMap.put("PascalCase" , new PascalCaseFormatter());
        formatMap.put("MySQLFriendly" , new SnakeCaseFormatter());
        formatMap.put("OracleFriendly" , new OracleFriendlyFormatter());
        formatMap.put("OracleFriendlyWithPrefix" , new OracleFriendlyWithPrefixFormatter());
        formatMap.put("MySQLFriendlyWithPrefix" , new MySQLFriendlyWithPrefixFormatter());
    }

    public static Formatter getFormat(String formatName){
        Formatter format = formatMap.get(formatName);
        return format;
    }
}
