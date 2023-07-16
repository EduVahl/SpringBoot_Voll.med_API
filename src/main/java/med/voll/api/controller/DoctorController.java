package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDataList;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.RegistrationDoctorData;
import med.voll.api.doctor.UpdateDoctorData;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorRepository repository;
	
	@PostMapping
	@Transactional
	public void registration(@RequestBody @Valid RegistrationDoctorData data) {
		repository.save(new Doctor(data));
	}
	
	@GetMapping
	public Page<DoctorDataList> list(@PageableDefault(sort = {"name"}, size = 10) Pageable pageable){
		return repository.findAllByActiveTrue(pageable).map(DoctorDataList::new);
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid UpdateDoctorData data) {
		var doctor = repository.getReferenceById(data.id());
		doctor.updateData(data);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deleteDoctorRegistration(@PathVariable Long id) {
		var doctor = repository.getReferenceById(id);
		doctor.inactivate();
	}
}
