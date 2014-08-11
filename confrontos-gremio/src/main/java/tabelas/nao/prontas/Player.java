package tabelas.nao.prontas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYERS")
@NamedQueries(value = { @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id") })
@PrimaryKeyJoinColumn(name = "id")
public class Player extends Person {

    private static final long serialVersionUID = 1L;

    @Column
    private String position;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long pk) {
        this.id = pk;
    }

}
