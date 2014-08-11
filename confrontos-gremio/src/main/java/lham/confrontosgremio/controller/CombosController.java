package lham.confrontosgremio.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import lham.confrontosgremio.enums.Continent;
import lham.confrontosgremio.enums.UfBrazil;

@ApplicationScoped
@Named(value = "combosMB")
public class CombosController {

    private List<Continent> continents;
    private List<UfBrazil> ufsBrazil;

    @PostConstruct
    public void init() {
        this.continents = Continent.getEnumList();
        this.ufsBrazil = UfBrazil.getEnumList();
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public List<UfBrazil> getUfsBrazil() {
        return ufsBrazil;
    }
    
}
