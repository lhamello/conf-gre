package lham.confrontosgremio.infra;

import java.io.Serializable;

import lham.confrontosgremio.util.FacesUtil;
import lham.confrontosgremio.util.MessageBundleUtil;

public abstract class AbstractController<E extends AbstractModel<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;

    private AbstractService<E, K> service;
    private E entity;
    private K id;

    public void saveOrUpdate() {
        if (entity.getId() == null) {
            entity = service.insert(entity);
            FacesUtil.addInfoMessage(MessageBundleUtil.getMessage("registro.inclui-sucesso"));
        } else {
            entity = service.altera(entity);
            FacesUtil.addInfoMessage(MessageBundleUtil.getMessage("registro.altera-sucesso"));
        }
        
        entity = service.findById(entity.getId());
    }

}
