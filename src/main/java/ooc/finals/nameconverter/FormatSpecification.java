package ooc.finals.nameconverter;

import lombok.Data;

@Data
public class FormatSpecification {
    private String name;
    private String type;
    private String format;

    FormatSpecification (String name,String type, String format){
        this.name = name.trim();
        this.type = type.trim();
        this.format = format.trim();
    }
}
