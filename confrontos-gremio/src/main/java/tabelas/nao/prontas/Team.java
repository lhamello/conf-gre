package tabelas.nao.prontas;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lham.confrontosgremio.enums.Confederation;
import lham.confrontosgremio.enums.TeamType;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TEAMS")
@NamedQueries(value = { @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id") })
public class Team extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Team_SEQ")
    @SequenceGenerator(name = "Team_SEQ", sequenceName = "TEAMS_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = true)
    @Length(max = 100)
    private String name;

    @Column(name = "COMMON_NAME", length = 30, nullable = false)
    @Length(max = 30)
    @NotBlank
    private String commonName;

    @Column(name = "CONFEDERATION", length = 8, nullable = false)
    @Enumerated(EnumType.STRING)
    private Confederation confederation;

    @Column(name = "TYPE", length = 13, nullable = false)
    @Enumerated(EnumType.STRING)
    private TeamType type;

    @ForeignKey(name = "TEAMS_LOCAL_CITIES_FK")
    @JoinColumn(name = "LOCAL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private City local;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "opponent")
    private Set<Match> matches;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Stadium> stadiums;
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public Confederation getConfederation() {
        return confederation;
    }

    public void setConfederation(Confederation confederation) {
        this.confederation = confederation;
    }

    public TeamType getType() {
        return type;
    }

    public void setType(TeamType type) {
        this.type = type;
    }

    public City getLocal() {
        return local;
    }

    public void setLocal(City local) {
        this.local = local;
    }

    public Set<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(Set<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

}
