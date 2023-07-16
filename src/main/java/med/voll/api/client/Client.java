package med.voll.api.client;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "clients")
@Entity(name = "client")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String cpf;
	private String phone;
	
	@Embedded
	private Address address;
	
	public Client(ClientRegistrationData data) {
		this.name = data.name();
		this.email = data.email();
		this.cpf = data.cpf();
		this.phone = data.phone();
		this.address = new Address(data.address());
	}
	
	public void updateData(UpdateClientData data) {
		if(data.name() != null) {
			this.name = data.name();
		}
		if(data.phone() != null) {
			this.phone = data.phone();
		}
		if(data.address() != null) {
			this.address.updateAddress(data.address());
		}
	}
}
