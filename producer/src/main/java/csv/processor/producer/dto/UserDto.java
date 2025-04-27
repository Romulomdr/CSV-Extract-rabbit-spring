package csv.processor.producer.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private Integer idade;
	
	public UserDto() {
	}

	public UserDto(String name, String email, Integer idade) {
		this.name = name;
		this.email = email;
		this.idade = idade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", idade=" + idade + "]";
	}
	
}
