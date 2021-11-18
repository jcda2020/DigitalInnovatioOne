package one.digitalinnovation.personMyApi.utils;

import one.digitalinnovation.personMyApi.dto.request.PhoneDTO;
import one.digitalinnovation.personMyApi.entity.Phone;
import one.digitalinnovation.personMyApi.enums.PhoneType;

public class PhoneUtils {
	
	
	private static final String PHONE_NUMBER = "8144444-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

}
