package com.inter.contants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeLog {

	BASIC("Basic"),
	MEDIUM("Medium"),
	HARD("Hard");

	private String description;

}
