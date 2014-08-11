package lham.confrontosgremio.enums;

import java.util.List;

import lham.confrontosgremio.util.SortUtil;


public enum UfBrazil {

    AC((byte) 1,  "AC", "Acre"),
    AL((byte) 2,  "AL", "Alagoas"),
    AM((byte) 3,  "AM", "Amazonas"),
    AP((byte) 4,  "AP", "Amapá"),
    BA((byte) 5,  "BA", "Bahia"),
    CE((byte) 6,  "CE", "Ceará"),
    DF((byte) 7,  "DF", "Distrito Federal"),
    ES((byte) 8,  "ES", "Espírito Santo"),
    GO((byte) 9,  "GO", "Goiás"),
    MA((byte) 10, "MA", "Maranhão"),
    MG((byte) 11, "MG", "Minas Gerais"),
    MS((byte) 12, "MS", "Mato Grosso do Sul"),
    MT((byte) 13, "MT", "Mato Grosso"),
    PA((byte) 14, "PA", "Pará"),
    PB((byte) 15, "PB", "Paraíba"),
    PE((byte) 16, "PE", "Pernambuco"),
    PI((byte) 17, "PI", "Piauí"),
    PR((byte) 18, "PR", "Paraná"),
    RJ((byte) 19, "RJ", "Rio de Janeiro"),
    RN((byte) 20, "RN", "Rio Grande do Norte"),
    RO((byte) 21, "RO", "Rondônia"),
    RR((byte) 22, "RR", "Roraima"),
    RS((byte) 23, "RS", "Rio Grande do Sul"),
    SC((byte) 24, "SC", "Santa Catarina"),
    SE((byte) 25, "SE", "Sergipe"),
    SP((byte) 26, "SP", "São Paulo"),
    TO((byte) 27, "TO", "Tocantins");

    private Byte code;
    private String abbreviation;
    private String name;
    
    private UfBrazil(final Byte code, final String abbreviation, final String name) {
        this.code = code;
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
    
    public static List<UfBrazil> getEnumList() {
        return SortUtil.sortEnumList(UfBrazil.class, "abbreviation");
    }
    
}
