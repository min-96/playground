package org.hdcd.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodeLabelValue {
	private String label;
	private String value;
	
	public CodeLabelValue(String value, String label) {
		this.value=value;
		this.label =label;
	}


}
