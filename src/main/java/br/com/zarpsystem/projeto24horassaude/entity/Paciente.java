package br.com.zarpsystem.projeto24horassaude.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.zarpsystem.projeto24horassaude.enums.TipoSanguineo;

@Entity
@Table(name = "tb_paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6406033390695874097L;

	@Id
	@GeneratedValue(generator="SQ_PACIENTE", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="SQ_PACIENTE", sequenceName="SQ_PACIENTE")
	@Column(name = "id_paciente")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "nome_pai")
	private String nomePai;

	@Column(name = "nome_mae")
	private String nomeMae;

	@Column(name = "tipo_sanguineo")
	private TipoSanguineo tipoSanguineo;

	@OneToMany(mappedBy="paciente")
	private List<PacientePatologia> patologiaList;

	@OneToMany(mappedBy="paciente")
	private List<PacienteAlergia> alergiaList;

	@OneToMany(mappedBy="paciente")
	private List<PacienteVacina> vacinaList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public List<PacientePatologia> getPatologiaList() {
		return patologiaList;
	}

	public void setPatologiaList(List<PacientePatologia> patologiaList) {
		this.patologiaList = patologiaList;
	}

	public List<PacienteAlergia> getAlergiaList() {
		return alergiaList;
	}

	public void setAlergiaList(List<PacienteAlergia> alergiaList) {
		this.alergiaList = alergiaList;
	}

	public List<PacienteVacina> getVacinaList() {
		return vacinaList;
	}

	public void setVacinaList(List<PacienteVacina> vacinaList) {
		this.vacinaList = vacinaList;
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
