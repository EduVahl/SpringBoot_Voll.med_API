package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.client.Client;
import med.voll.api.client.ClientDataList;
import med.voll.api.client.ClientRegistrationData;
import med.voll.api.client.ClientRepository;
import med.voll.api.client.UpdateClientData;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@PostMapping
	@Transactional
	public void registration(@RequestBody @Valid ClientRegistrationData data) {
		repository.save(new Client(data));
	}
	
	@GetMapping
	public Page<ClientDataList> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
		return repository.findAll(pageable).map(ClientDataList::new);
	}
	
	@PutMapping
	@Transactional
	public void updateClientData(@RequestBody @Valid UpdateClientData data) {
		var client = repository.getReferenceById(data.id());
		client.updateData(data);
	}
}
