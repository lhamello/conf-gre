package lham.confrontosgremio.business.country;

import javax.inject.Inject;
import javax.inject.Named;

import lham.confrontosgremio.infra.AbstractController;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

@Named("countryMB")
@ViewAccessScoped
public class CountryController extends AbstractController {

    private static final long serialVersionUID = 1L;

    @Inject
    private Country country;

    @Inject
    private CountryService countryService;

    public void save() {
        countryService.insert(country);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

}
