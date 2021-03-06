package br.com.zarpsystem.projeto24horassaude.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_paciente_vacina")
public class PacienteVacina implements Serializable {

	private static final long serialVersionUID = 8462498044045426469L;

	@Id
	@GeneratedValue(generator="SQ_PACIENTE_VACINA", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="SQ_PACIENTE_VACINA", sequenceName="SQ_PACIENTE_VACINA")
	@Column(name = "id_paciente_vacina")
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_paciente", referencedColumnName="id_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name="id_vacina", referencedColumnName="id_vacina")
	private Vacina vacina;

	@Column(name = "data_vacinacao")
	private LocalDate dataVacinacao;

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

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
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
		PacienteVacina other = (PacienteVacina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
