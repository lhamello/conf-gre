package lham.confrontosgremio.business.match;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

import lham.confrontosgremio.business.team.Team;
import lham.confrontosgremio.infra.AbstractModel;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MATCHES")
@NamedQueries(value = { @NamedQuery(name = "Match.findById", query = "SELECT m FROM Match m WHERE m.id = :id") })
public class Match extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Match_SEQ")
    @SequenceGenerator(name = "Match_SEQ", sequenceName = "MATCHES_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NUMBER", nullable = false)
    private Long number;

    @Column(name = "DATE", nullable = false, columnDefinition = "date")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "NUMBER_AGAINST_OPPONENT", nullable = false)
    private Long numberAgainstOpponent;

    @ForeignKey(name = "MATCHES_OPPONENT_TEAM_FK")
    @JoinColumn(name = "OPPONENT", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Team opponent;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long pk) {
        this.id = pk;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getNumberAgainstOpponent() {
        return numberAgainstOpponent;
    }

    public void setNumberAgainstOpponent(Long numberAgainstOpponent) {
        this.numberAgainstOpponent = numberAgainstOpponent;
    }

    public Team getOpponent() {
        return opponent;
    }

    public void setOpponent(Team opponent) {
        this.opponent = opponent;
    }

}