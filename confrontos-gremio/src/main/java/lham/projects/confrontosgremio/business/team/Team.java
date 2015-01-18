package lham.projects.confrontosgremio.business.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lham.projects.confrontosgremio.infra.AbstractEntity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Entidade que representa um time.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Entity
@Table(name = "TEAM")
@NamedQueries(value = { @NamedQuery(name = "Team.findByPk", query = "SELECT t FROM Team t WHERE t.uniqueId = :pk") })
public final class Team extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Team_SEQ")
    @SequenceGenerator(name = "Team_SEQ", sequenceName = "TEAM_ID_SEQ", allocationSize = 1)
    private Long uniqueId;

    @Column(name = "FULL_NAME", length = 100, nullable = false)
    @Length(max = 100)
    @NotBlank
    private String fullName;

    @Column(name = "COMMON_NAME", length = 30, nullable = false)
    @Length(max = 30)
    @NotBlank
    private String commonName;

    /**
     * Construtor vazio padrão.
     */
    public Team() {
        super();
    }

    /**
     * Retorna o identificador único do time.<br>
     * 
     * @return identificador único do time.
     */
    public Long getUniqueId() {
        return uniqueId;
    }

    /**
     * Define o identificador único do time.
     * 
     * @param uniqueId
     *            identificador único para o time.
     */
    public void setUniqueId(final Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Retorna o nome completo do time.
     * 
     * @return o nome do completo.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Define o nome do completo do time.<br>
     * O nome completo devo ter no máximo 100 caracteres e não pode ser nulo.
     * 
     * @param fullName
     *            nome completo para o time.
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retorna o nome comum do time, ou seja, o nome popularmente conhecido.
     * 
     * @return nome comum do time.
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * Define o nome comum do time, ou seja, o nome pelo qual o time é
     * popularmente conhecido.<br>
     * O nome comum deve ter no máximo 30 caracteres e não pode ser nulo.
     * 
     * @param commonName
     *            nome comum para o time.
     */
    public void setCommonName(final String commonName) {
        this.commonName = commonName;
    }

    /**
     * Retorna a chave a primária do time que é <i>idTeam</i>.
     */
    @Override
    public Long getPrimaryKey() {
        return this.getUniqueId();
    }

    /**
     * Define o valor da chave primária do time que é <i>idTeam</i>.
     */
    @Override
    public void setPrimaryKey(final Long primaryKey) {
        this.setUniqueId(primaryKey);
    }
}
