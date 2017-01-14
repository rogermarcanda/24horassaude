package br.com.zarpsystem.projeto24horassaude.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zarpsystem.projeto24horassaude.enums.Risco;

@Entity
@Table(name = "tb_paciente_alergia")
public class PacienteAlergia implements Serializable {

	private static final long serialVersionUID = 1367026163103739821L;

	@Id
	@GeneratedValue(generator="SQ_PACIENTE_ALERGIA", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="SQ_PACIENTE_ALERGIA", sequenceName="SQ_PACIENTE_ALERGIA")
	@Column(name = "id_paciente_alergia")
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_paciente", referencedColumnName="id_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name="id_alergia", referencedColumnName="id_alergia")
	private Alergia alergia;

	@Column(name = "risco")
	private Risco risco;

	@OneToMany
	private List<Tratamento> tratamentoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Paciente getPaciente() {
		return paciente;
	}

	@JsonProperty
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public List<Tratamento> getTratamentoList() {
		return tratamentoList;
	}

	public void setTratamentoList(List<Tratamento> tratamentoList) {
		this.tratamentoList = tratamentoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteAlergia other = (PacienteAlergia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
