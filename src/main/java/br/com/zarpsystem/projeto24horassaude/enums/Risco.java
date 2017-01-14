package br.com.zarpsystem.projeto24horassaude.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Risco {
	
	RISCO_I ("1", "RISCO I"),
	RISCO_II ("2", "RISCO II"),
	RISCO_III ("3", "RISCO III"),
	RISCO_IV ("4", "RISCO IV"),
	RISCO_V ("5", "RISCO V");
	
	private final String code;
	private final String key;

	private Risco(String code, String key) {
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
	public static Risco fromCode(String code){
		for (Risco risco : Risco.values()) {
			if(risco.getCode().equals(code)){
				return risco;
			}
		}
		return null;
	}
	

}
