package br.com.zarpsystem.projeto24horassaude.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoSanguineo {
	
	A_POSITIVO ("A+", "A+"),
	A_NEGATIVO ("A-", "A-"),
	B_POSITIVO ("B+", "B+"),
	B_NEGATIVO ("B-", "B-"),
	AB_POSITIVO ("AB+", "AB+"),
	AB_NEGATIVO ("AB-", "AB-"),
	O_POSITIVO ("0+", "0+"),
	O_NEGATIVO ("O-", "O-");
	
	private final String code;
	private final String key;

	private TipoSanguineo(String code, String key) {
		this.code = code;
		this.key = key;
	}

	public String getCode() {
		return code;
	}
	
	public String getKey() {
		return key;
	}

	public String toValue() {
		return code;
	}

	@JsonCreator
	public static TipoSanguineo fromCode(String code){
		for (TipoSanguineo tipoSanguineo : TipoSanguineo.values()) {
			if(tipoSanguineo.getCode().equals(code)){
				return tipoSanguineo;
			}
		}
		return null;
	}
}
