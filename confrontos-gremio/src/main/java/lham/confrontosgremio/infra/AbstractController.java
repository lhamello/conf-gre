package lham.confrontosgremio.infra;

import java.io.Serializable;

import lham.confrontosgremio.util.FacesUtil;
import lham.confrontosgremio.util.MessageBundleUtil;

public abstract class AbstractController<E extends AbstractModel<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected AbstractService<E, K> service;
    protected E entity;
    
    public abstract void createController();
        
    public E findById(final E entity) {
        return service.findById(entity.getId());
    }
    
    public void update() {
        entity = service.update(entity);
        FacesUtil.addInfoMessage(MessageBundleUtil.getMessage("info.message.success.update"));
        entity = this.findById(entity);
    }
    
    public String save() {
        entity = service.insert(entity);
        FacesUtil.addInfoMessage(MessageBundleUtil.getMessage("info.message.success.save"));
        entity = this.findById(entity);
        return "";
    }

    public AbstractService<E, K> getService() {
        return service;
    }

    public void setService(final AbstractService<E, K> service) {
        this.service = service;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(final E entity) {
        this.entity = entity;
    }
    
}
