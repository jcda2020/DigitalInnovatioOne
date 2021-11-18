package one.digitalinnovation.personMyApi.enums;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
public enum PhoneType {
	
	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	private final String description;
	
	@Autowired
	@Builder 
	PhoneType(String string) {
		this.description = "";
		// TODO Auto-generated constructor stub
	}


}
