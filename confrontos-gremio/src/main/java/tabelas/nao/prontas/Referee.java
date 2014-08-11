package tabelas.nao.prontas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "REFEREES")
@NamedQueries(value = { @NamedQuery(name = "Referee.findById", query = "SELECT r FROM Referee r WHERE r.id = :id") })
@PrimaryKeyJoinColumn(name = "id")
public class Referee extends Person {

    private static final long serialVersionUID = 1L;

    @Column
    private String function;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long pk) {
        this.id = pk;
    }

}
