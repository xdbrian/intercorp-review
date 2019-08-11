package review.intercorp.client.util;

import lombok.Getter;

@Getter
public enum SexEnum {

    MASCULINO("M","male"),
    FEMENINO("F","female");

    private String value;
    private String codeExternal;
    SexEnum(String value, String codeExternal) {
        this.value= value;
        this.codeExternal = codeExternal;
    }

    public static SexEnum get(String name) {
        return Enum.valueOf(SexEnum.class, name);
    }
}
