package lham.confrontosgremio.business.country;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import lham.confrontosgremio.exception.ExceptionHandlerInterceptor;
import lham.confrontosgremio.infra.AbstractService;

@Default
@ExceptionHandlerInterceptor
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CountryService extends AbstractService<Country, Short> {

    private static final long serialVersionUID = 1L;

    @Inject
    private CountryDAO countryDAO;

    @Override
    @PostConstruct
    public void initDAO() {
        super.setDAO(countryDAO);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Country insert(Country entity) {
        return super.insert(entity);
    }
    
}
