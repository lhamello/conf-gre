package tabelas.nao.prontas;

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

import lham.confrontosgremio.business.city.City;
import lham.confrontosgremio.infra.AbstractModel;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "AA")
@NamedQueries(value = { @NamedQuery(name = "OfficialMatch.findById", query = "SELECT om FROM Match om WHERE om.id = :id") })
public class OfficialMatch extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Match_SEQ")
    @SequenceGenerator(name = "Match_SEQ", sequenceName = "MATCHES_ID_SEQ", allocationSize = 1)
    private Long id;
    
    @Column(name = "TYPE", length = 13, nullable = false)
    private Long number;
    
    @ForeignKey(name = "MATCHES_LOCAL_CITIES_FK")
    @JoinColumn(name = "LOCAL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private City local;
    
    private Stadium stadium;
    
    private Integer numberAgainstOponnent;
    
    private Team opponent;
    
    private Byte scoredGoals;
    
    private Byte sufferedGoals;
    
    private Byte extraTimeScoredGoals;
    
    private Byte extraTimeSufferedGoals;
    
    private Byte penaltiesScoredGoals;
    
    private Byte penaltiesSufferedGoals;
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long pk) {
        this.id = pk;
    }

}
