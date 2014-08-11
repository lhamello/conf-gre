package lham.confrontosgremio.business.city;

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
public class CityService extends AbstractService<City, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private CityDAO cityDAO;

    @Override
    @PostConstruct
    public void initDAO() {
        super.setDAO(cityDAO);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public City insert(City entity) {
        return super.insert(entity);
    }
    
}
