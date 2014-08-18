package lham.confrontosgremio.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

@FacesConverter(value = "trimConverter")
public class TrimConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
        return StringUtils.trimToNull(value);
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object object) {
        return (object == null) ? null : object.toString();
    }

}
