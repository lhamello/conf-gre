package lham.confrontosgremio.enums;

import java.util.List;

import lham.confrontosgremio.util.SortUtil;

public enum Continent {

    AF((byte) 1, "África"),

    AS((byte) 2, "Ásia"),

    EU((byte) 3, "Europa"),

    NA((byte) 4, "América do Norte"),

    OC((byte) 5, "Oceania"),

    SA((byte) 6, "América do Sul");

    private Byte code;
    private String name;

    private Continent(final Byte code, final String name) {
        this.code = code;
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static List<Continent> getEnumList() {
        return SortUtil.sortEnumList(Continent.class, "name");
    }

}
