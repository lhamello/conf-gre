package lham.confrontosgremio.enums;

import java.util.List;

import lham.confrontosgremio.util.SortUtil;

public enum Confederation {

    AFC((byte) 1, "AFC", "Confederação Asiática de Futebol"),

    CAF((byte) 2, "CAF", "Confederação Africana de Futebol"),

    CONCACAF((byte) 3, "AFC", "Confederação de Futebol da América do Norte, Central e Caribe"),

    CONMEBOL((byte) 4, "CONMEBOL", "Confederação Sul-Americana de Futebol"),

    OFC((byte) 5, "OFC", "Confederação de Futebol da Oceania"),

    UEFA((byte) 6, "UEFA", "União das Associações Europeias de Futebol");

    private Byte code;
    private String acronym;
    private String name;

    private Confederation(final Byte code, final String acronym, final String name) {
        this.code = code;
        this.acronym = acronym;
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public static List<Confederation> getEnumList() {
        return SortUtil.sortEnumList(Confederation.class, "acronym");
    }

}
