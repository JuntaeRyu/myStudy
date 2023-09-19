package com.ryu.app;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VO {
	@NotNull(message="id값 null")
	@NotEmpty(message="id값 empty")
	@Size(min=5, max=100, message="id값 6이상 100이하 가능")
	private String id;
	@NotNull(message="password값 null")
	@NotEmpty(message="password값 empty")
	private String password;
}
