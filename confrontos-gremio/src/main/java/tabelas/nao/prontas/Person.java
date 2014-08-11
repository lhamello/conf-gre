package tabelas.nao.prontas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lham.confrontosgremio.business.city.City;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.annotations.ForeignKey;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONS")
@NamedQueries(value = { @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id") })
public class Person extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Stadium_SEQ")
    @SequenceGenerator(name = "Stadium_SEQ", sequenceName = "STADIUMS_ID_SEQ", allocationSize = 1)
    protected Long id;

    @ForeignKey(name = "STADIUMS_LOCAL_CITIES_FK")
    @JoinColumn(name = "LOCAL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private City nationality;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long pk) {
        this.id = pk;
    }

}
