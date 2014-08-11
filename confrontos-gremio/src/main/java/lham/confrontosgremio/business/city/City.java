package lham.confrontosgremio.business.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lham.confrontosgremio.business.uf.UnityFederation;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity that represents a city. Table have this attributes:
 * <ul>
 *      <li>id</li> - unique identifier (primary key) of the city;
 *      <li>name</li> - city name;
 *      <li>uf</li> - UF of the city;
 * </ul>
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Entity
@Table(name = "CITIES", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "uf" }, name = "CITIES_NAME_UF_KEY") })
@NamedQueries(value = { @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id") })
public class City extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "City_SEQ")
    @SequenceGenerator(name = "City_SEQ", sequenceName = "CITIES_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 60, nullable = false)
    @Length(max = 60)
    @NotBlank
    private String name;

    @ForeignKey(name = "CITIES_UF_UFS_FK")
    @JoinColumn(name = "UF", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UnityFederation uf;

    /**
     * Returns the unique identifier of the city (primary key).
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the city.
     * 
     * @param id
     *            unique identifier (primary key).
     */
    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Returns the city name.
     * 
     * @return the city name;
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the city name.
     * <p>
     * The city name must contain a maximum 60 characters.
     * 
     * @param name
     *            city name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the UF of the city.
     * 
     * @return the UF of the city.
     */
    public UnityFederation getUf() {
        return uf;
    }

    /**
     * Sets the UF of the city.
     * 
     * @param uf
     *            the UF of the city.
     */
    public void setUf(UnityFederation uf) {
        this.uf = uf;
    }

}
