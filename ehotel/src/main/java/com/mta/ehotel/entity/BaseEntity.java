package com.mta.ehotel.entity;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@TypeDefs({ @TypeDef(name = "enum-string", typeClass = PostgreSQLEnumType.class),
		@TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class), })
@MappedSuperclass
public abstract class BaseEntity {
	protected String checkNullToParseNumber(String input) {
		return input == null || input.isEmpty() ? "0" : input;
	}
}
