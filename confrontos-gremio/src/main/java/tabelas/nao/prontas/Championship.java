package tabelas.nao.prontas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lham.confrontosgremio.enums.ChampionshipLevel;
import lham.confrontosgremio.infra.AbstractModel;

@Entity
@Table(name = "CHAMPIONSHIPS")
@NamedQueries(value = { @NamedQuery(name = "Championship.findById", query = "SELECT c FROM Championship c WHERE c.id = :id") })
public class Championship extends AbstractModel<Short> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Championship_SEQ")
    @SequenceGenerator(name = "Championship_SEQ", sequenceName = "CHAMPIONSHIPS_ID_SEQ", allocationSize = 1)
    private Short id;
    
    private String name;
    
    private ChampionshipLevel level;
    
    public Short getId() {
        return id;
    }

    public void setId(final Short id) {
        this.id = id;
    }

}
