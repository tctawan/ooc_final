package ooc.finals.nameconverter;

import ooc.finals.nameconverter.formats.*;

import java.util.HashMap;
import java.util.Map;

public class FormatFactory {
    static Map<String, Format> formatMap = new HashMap<>();
    static {
        formatMap.put("camelCase" , new CamelCaseFormat());
        formatMap.put("snake_case" , new SnakeCaseFormat());
        formatMap.put("lowercase" , new LowerCaseFormat());
        formatMap.put("UPPERCASE" , new UpperCaseFormat());
        formatMap.put("kebab-case" , new KebabCaseFormat());
        formatMap.put("PascalCase" , new PascalCaseFormat());
        formatMap.put("MySQLFriendly" , new SnakeCaseFormat());
        formatMap.put("OracleFriendly" , new OracleFriendlyFormat());
        formatMap.put("OracleFriendlyWithPrefix" , new OracleFriendlyWithPrefixFormat());
        formatMap.put("MySQLFriendlyWithPrefix" , new MySQLFriendlyWithPrefixFormat());
    }

    public static Format getFormat(String formatName){
        Format format = formatMap.get(formatName);
        return format;

    }
}
