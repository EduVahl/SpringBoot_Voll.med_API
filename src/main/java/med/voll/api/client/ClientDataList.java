package med.voll.api.client;

public record ClientDataList(Long id, String name, String email, String cpf) {
	
	public ClientDataList(Client client) {
		this(client.getId(), client.getName(),client.getEmail(),client.getCpf());
	}
}
