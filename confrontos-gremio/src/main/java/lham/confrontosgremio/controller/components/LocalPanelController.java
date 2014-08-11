package lham.confrontosgremio.controller.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import lham.confrontosgremio.business.city.City;
import lham.confrontosgremio.business.country.Country;
import lham.confrontosgremio.controller.CombosController;
import lham.confrontosgremio.enums.Continent;
import lham.confrontosgremio.enums.UfBrazil;

import org.apache.commons.lang3.StringUtils;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

@Named(value = "localPanelMB")
@ViewAccessScoped
public class LocalPanelController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Continent continent;
    private Country country;
    private UfBrazil uf;
    private City city;
    
    @Inject
    private CombosController combosController;
    
    public void clearLocal() {
        this.continent = null;
        this.country = new Country();
        this.uf = null;
        this.city = new City();
    }
    
    public List<Continent> completeContinent(String query) {
        List<Continent> filter = new ArrayList<>(6);
        List<Continent> continents = combosController.getContinents();

        if (StringUtils.isEmpty(query)) {
            filter = continents;
        } else {

            for (Continent continent : continents) {
                String continentName = continent.getName();

                if (StringUtils.containsIgnoreCase(continentName, query)) {
                    filter.add(continent);
                }
            }
        }

        return filter;
    }
    
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public UfBrazil getUf() {
        return uf;
    }

    public void setUf(UfBrazil uf) {
        this.uf = uf;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
