package lham.confrontosgremio.business.country;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lham.confrontosgremio.business.uf.UnityFederation;
import lham.confrontosgremio.enums.Continent;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity that represents a country. Table have this attributes:
 * <ul>
 *      <li>id</li> - unique identifier (primary key) of the country;
 *      <li>abbreviation</li> - country abbreviation;
 *      <li>name</li> - country name;
 *      <li>continent</li> - country's continent;
 * </ul>
 * Attributes of relationship:
 * <p>
 * <ul>
 *      <li>ufs</li> - list of states/provinces of the country;
 * </ul>
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Entity
@Table(name = "COUNTRIES")
@NamedQueries(value = { @NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id") })
public class Country extends AbstractModel<Short> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Country_SEQ")
    @SequenceGenerator(name = "Country_SEQ", sequenceName = "COUNTRIES_ID_SEQ", allocationSize = 1)
    private Short id;

    @Column(name = "ABBREVIATION", length = 3, nullable = false, unique = true)
    @Length(min = 3, max = 3)
    @NotBlank
    public String abbreviation;

    @Column(name = "NAME", length = 40, nullable = false, unique = true)
    @Length(max = 40)
    @NotBlank
    private String name;

    @Column(name = "CONTINENT", length = 2, nullable = false)
    @Enumerated(EnumType.STRING)
    private Continent continent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<UnityFederation> ufs;

    /**
     * Returns the unique identifier (primary key) of the country.
     */
    @Override
    public Short getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the country.
     * 
     * @param id
     *            unique identifier (primary key).
     */
    @Override
    public void setId(final Short id) {
        this.id = id;
    }

    /**
     * Returns the country abbreviation.
     * 
     * @return the country abbreviation;
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the country abbreviation.
     * <p>
     * The abbreviation must contain 3 characters.
     * 
     * @param abbreviation
     *            country abbreviation.
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Returns the country name.
     * 
     * @return the country name;
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the country name.
     * <p>
     * The country must contain a maximum 40 characters.
     * 
     * @param name
     *            country name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the continent of the country.
     * 
     * @return the continent of the country;
     */
    public Continent getContinent() {
        return continent;
    }

    /**
     * Sets the continent of the country.
     * <p>
     * The continent must contain 2 characters.
     * 
     * @param continent
     *            continent of the country.
     */
    public void setContinent(final Continent continent) {
        this.continent = continent;
    }

    /**
     * Returns the list of states/provinces forming part of a country.
     * 
     * @return list of states/provinces forming part of a country.
     */
    public Set<UnityFederation> getUfs() {
        return ufs;
    }

    /**
     * Sets the list of ufs forming part of a country.
     * 
     * @param ufs
     *            ufs forming part of a country.
     */
    public void setUfs(final Set<UnityFederation> ufs) {
        this.ufs = ufs;
    }

}
