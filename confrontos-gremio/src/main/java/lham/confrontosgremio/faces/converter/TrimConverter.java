package lham.confrontosgremio.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "trimConverter")
public class TrimConverter implements Converter {

    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
        if (value != null) {
            return value.trim();
        } else {
            return value;
        }
    }

    public String getAsString(final FacesContext context, final UIComponent component, final Object object) {
        String value = null;
        
        if (object != null) {
            value = object.toString();
        }
        
        return value;
    }

}
