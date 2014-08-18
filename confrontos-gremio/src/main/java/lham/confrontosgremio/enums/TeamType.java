package lham.confrontosgremio.enums;

import java.util.List;

import lham.confrontosgremio.util.SortUtil;

public enum TeamType {

    CLUB((byte) 1, "Club"),

    COMBINED((byte) 2, "Combinado"),

    NATIONAL_TEAM((byte) 3, "Seleção Nacional"),
    
    REGIONAL_TEAM((byte) 4, "Seleção Regional");

    private Byte code;
    private String description;

    private TeamType(final Byte code, final String description) {
        this.code = code;
        this.description = description;
    }

    public Byte getCode() {
        return code;
    }

    public String getName() {
        return description;
    }

    public static List<TeamType> getEnumList() {
        return SortUtil.sortEnumList(TeamType.class, "description");
    }

}
