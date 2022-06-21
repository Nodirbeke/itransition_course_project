package itransition.intern.itransitioncollection.enums;

public enum AuthRole {

    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    private final String value;


    AuthRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
