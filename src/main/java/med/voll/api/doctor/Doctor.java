package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Boolean active;
	private String name;
	private String email;
	private String phone;
	private String crm;
	
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	
	@Embedded
	private Address address;
	
	public Doctor(RegistrationDoctorData data) {
		this.active = true;
		this.name = data.name();
		this.email = data.email();
		this.phone = data.phone();
		this.crm = data.crm();
		this.specialty = data.specialty();
		this.address = new Address(data.address());
	}
	
	public void updateData(UpdateDoctorData data) {
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
	
	public void inactivate() {
		this.active = false;
	}
}
