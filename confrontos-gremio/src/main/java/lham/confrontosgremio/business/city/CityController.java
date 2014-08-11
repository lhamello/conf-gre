package lham.confrontosgremio.business.city;

import javax.inject.Inject;
import javax.inject.Named;

import lham.confrontosgremio.infra.AbstractController;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

@Named("cityMB")
@ViewAccessScoped
public class CityController extends AbstractController {

    private static final long serialVersionUID = 1L;

    @Inject
    private City city;

    @Inject
    private CityService cityService;;

    public void save() {
        cityService.insert(city);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
