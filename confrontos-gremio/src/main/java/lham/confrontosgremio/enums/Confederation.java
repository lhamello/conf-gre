package lham.confrontosgremio.enums;

import java.util.List;

import lham.confrontosgremio.util.SortUtil;

public enum Confederation {

    AFC((byte) 1, "AFC", "Confedera��o Asi�tica de Futebol"),

    CAF((byte) 2, "CAF", "Confedera��o Africana de Futebol"),

    CONCACAF((byte) 3, "AFC", "Confedera��o de Futebol da Am�rica do Norte, Central e Caribe"),

    CONMEBOL((byte) 4, "CONMEBOL", "Confedera��o Sul-Americana de Futebol"),

    OFC((byte) 5, "OFC", "Confedera��o de Futebol da Oceania"),

    UEFA((byte) 6, "UEFA", "Uni�o das Associa��es Europeias de Futebol");

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
