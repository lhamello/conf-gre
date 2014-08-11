package lham.confrontosgremio.business.uf;

import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lham.confrontosgremio.business.city.City;
import lham.confrontosgremio.business.country.Country;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity that represents a Unity Federation. Table have this attributes:
 * <ul>
 *      <li>id</li> - unique identifier (primary key) of the UF;
 *      <li>abbreviation</li> - UF abbreviation;
 *      <li>name</li> - UF name;
 *      <li>country</li> - country's UF;
 * </ul>
 * Attributes of relationship:
 * <p>
 * <ul>
 *      <li>cities</li> - list of cities of the UF;
 * </ul>
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Entity
@Table(name = "UFS", uniqueConstraints = { @UniqueConstraint(columnNames = { "abbreviation", "name", "country" }, name = "UFS_ABBREVIATION_NAME_COUNTRY_KEY") })
@NamedQueries(value = { @NamedQuery(name = "UnityFederation.findById", query = "SELECT uf FROM UnityFederation uf WHERE uf.id = :id") })
public class UnityFederation extends AbstractModel<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UnityFederation_SEQ")
    @SequenceGenerator(name = "UnityFederation_SEQ", sequenceName = "UFS_ID_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "ABBREVIATION", length = 3, nullable = false)
    @Length(min = 2, max = 3)
    @NotBlank
    private String abbreviation;

    @Column(name = "NAME", length = 30, nullable = false)
    @Length(max = 20)
    @NotBlank
    private String name;

    @ForeignKey(name = "UFS_COUNTRY_COUNTRIES_FK")
    @JoinColumn(name = "COUNTRY", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uf")
    private Set<City> cities;

    /**
     * Returns the unique identifier (primary key) of the UF.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the UF.
     * 
     * @param id
     *            unique identifier (primary key).
     */
    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Returns the abbreviation of the UF.
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the abbreviation of the UF.
     * <p>
     * The abbreviation must contain a minimum of 2 characters and a maximum of
     * 3 characters.
     * 
     * @param abbreviation
     *            the abbreviation of the UF.
     */
    public void setAbbreviation(final String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Returns the UF name.
     * 
     * @return the UF name;
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the UF name.
     * <p>
     * The UF name must contain a maximum 20 characters.
     * 
     * @param name
     *            city name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the Country of the UF.
     * 
     * @return the Country of the UF.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets the Country of the UF.
     * 
     * @param country
     *            the Country of the UF.
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Returns the list of cities which contains this UF.
     * 
     * @return list of cities which contains this UF.
     */
    public Set<City> getCities() {
        return cities;
    }

    /**
     * Sets the list of cities which contains this division.
     * 
     * @param cities
     *            list of cities which contains this division.
     */
    public void setCountries(final Set<City> cities) {
        this.cities = cities;
    }

}
