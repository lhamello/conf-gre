package tabelas.nao.prontas;

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

import lham.confrontosgremio.business.city.City;
import lham.confrontosgremio.business.match.Match;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "STADIUMS")
@NamedQueries(value = { @NamedQuery(name = "Stadium.findById", query = "SELECT s FROM Stadium s WHERE s.id = :id") })
public class Stadium extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Stadium_SEQ")
    @SequenceGenerator(name = "Stadium_SEQ", sequenceName = "STADIUMS_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = true)
    @Length(max = 100)
    private String name;

    @Column(name = "COMMON_NAME", length = 30, nullable = false)
    @Length(max = 30)
    @NotBlank
    private String commonName;

    @ForeignKey(name = "STADIUMS_OWNER_TEAMS_FK")
    @JoinColumn(name = "OWNER", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Team owner;

    @ForeignKey(name = "STADIUMS_LOCAL_CITIES_FK")
    @JoinColumn(name = "LOCAL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private City local;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stadium")
    private Set<Match> matches;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long pk) {
        this.id = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Team getOwner() {
        return owner;
    }

    public void setOwner(Team owner) {
        this.owner = owner;
    }

    public City getLocal() {
        return local;
    }

    public void setLocal(City local) {
        this.local = local;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

}
