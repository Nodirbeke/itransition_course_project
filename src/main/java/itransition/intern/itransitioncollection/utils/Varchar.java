package itransition.intern.itransitioncollection.utils;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.io.Serializable;

public class Varchar  implements Serializable {

    public String string;

    public Varchar(String string) {
        checkLength(string);
        this.string = string;
    }

    private void checkLength(String string) {
        if (string.length() > 255) throw new RuntimeException("CUSTOM_STRING_REQUIRED_255_CHARS");
    }


}
