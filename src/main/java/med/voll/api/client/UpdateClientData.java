package med.voll.api.client;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record UpdateClientData(
		@NotNull
		Long id, 
		String name, 
		String phone, 
		AddressData address) {
}
