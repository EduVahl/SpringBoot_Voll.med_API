package med.voll.api.doctor;

public record DoctorDataList(Long id, String name, String crm, String email, Specialty specialty) {
	
	public DoctorDataList(Doctor doctor) {
		this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getEmail(), doctor.getSpecialty());
	}
}
