package med.voll.api.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.AddressData;

public record ClientRegistrationData(
		
		@NotBlank
		String name,
		@NotBlank
		@Email
		String email,
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf, 
		@NotBlank
		String phone,
		@NotNull
		@Valid
		AddressData address) {
}
