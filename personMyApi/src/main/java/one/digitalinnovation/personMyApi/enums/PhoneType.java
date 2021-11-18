package one.digitalinnovation.personMyApi.enums;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor

public enum PhoneType {
	
	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	@Autowired
	PhoneType(String string) {
		this.description = "";
		// TODO Auto-generated constructor stub
	}

	private final String description;
}
