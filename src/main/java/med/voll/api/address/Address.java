package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String address; 
	private String district; 
	private String zipcode;
	private String city;
	private String state; 
	private String number; 
	private String complement;
	
	public Address(AddressData data) {
		this.address = data.address();
		this.district = data.district();
		this.zipcode = data.zipcode();
		this.city = data.city();
		this.state = data.state();
		this.number = data.number();
		this.complement = data.complement();
	}
	
	public void updateAddress(AddressData data) {
		if(data.address() != null) {
			this.address = data.address();
		}
		if(data.district() != null) {
			this.district = data.district();
		}
		if(data.zipcode() != null) {
			this.zipcode = data.zipcode();
		}
		if(data.city() != null) {
			this.city = data.city();
		}
		if(data.state() != null) {
			this.state = data.state();
		}
		if(data.number() != null) {
			this.number = data.number();
		}
		if(data.complement() != null) {
			this.complement = data.complement();
		}
	}
}
