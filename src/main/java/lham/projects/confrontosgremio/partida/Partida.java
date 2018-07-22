package lham.projects.confrontosgremio.partida;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Esta classe representa uma partida disputada pelo Grêmio.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Entity
@Table(name = "PARTIDA", uniqueConstraints = { 
        @UniqueConstraint(name = "PARTIDA_UK_NUMERO", columnNames = "numero"), 
        @UniqueConstraint(name = "PARTIDA_UK_DATA_HORARIO", columnNames = { "data", "horario" }) })
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador (único) da partida.
     */
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Partida_SEQ")
    @SequenceGenerator(name = "Partida_SEQ", sequenceName = "PARTIDA_SEQ", allocationSize = 1)
    private Long id;

    /**
     * Número da partida disputada pelo Grêmio na história.
     */
    @Column(name = "NUMERO", nullable = false)
    @NotNull
    private Long numero;

    /**
     * Data da realização da partida.
     */
    @Column(name = "DATA", nullable = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;

    /**
     * Horário da realização da partida.
     */
    @Column(name = "HORARIO", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date horario;
    
    /**
     * Retorna o número da partida disputada pelo Grêmio.
     * 
     * @return número da partida.
     */
    public Long getNumero() {
        return this.numero;
    }

    /**
     * Define o número da partida disputada pelo Grêmio.
     * 
     * @param numero
     *            número da partida.
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * Retorna a data da realização da partida.
     * 
     * @return data da partida.
     */
    public Date getData() {
        return (Date) this.data.clone();
    }

    /**
     * Define a data da realização da partida.
     * 
     * @param data
     *            data da partida.
     */
    public void setData(Date data) {
        this.data = (Date) data.clone();
    }
    
    /**
     * Retorna o horário da realização da partida.
     * 
     * @return horário da partida.
     */
    public Date getHorario() {
        return horario == null ? null : (Date) this.horario.clone();
    }

    /**
     * Define o horário da realização da partida.
     * 
     * @param horario
     *            horário da partida.
     */
    public void setHorario(Date horario) {
        this.horario = (horario == null ? null : (Date) horario.clone());  
    }

    /**
     * {@link java.lang.Object#hashCode()}
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    /**
     * {@link java.lang.Object#equals(Object)}
     */
    @Override
    public boolean equals(Object partida) {
        return EqualsBuilder.reflectionEquals(this, partida, false);
    }

    /**
     * {@link java.lang.Object#toString()}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE, true);
    }
}
