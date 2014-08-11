package lham.confrontosgremio.enums;

import java.util.List;

import lham.confrontosgremio.util.SortUtil;

/**
 * Enumerating levels of championships.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public enum ChampionshipLevel {

    STATE((byte) 1, "Estadual"),

    REGIONAL((byte) 2, "Regional"),

    NATIONAL((byte) 3, "Nacional"),

    CONTINENTAL((byte) 4, "Continental"),

    INTERNATIONAL((byte) 5, "Internacional");

    private Byte code;
    private String level;

    private ChampionshipLevel(final Byte code, final String level) {
        this.code = code;
        this.level = level;
    }

    public Byte getCode() {
        return code;
    }

    public String getLevel() {
        return level;
    }

    public static List<ChampionshipLevel> getEnumList() {
        return SortUtil.sortEnumList(ChampionshipLevel.class, "level");
    }

}
