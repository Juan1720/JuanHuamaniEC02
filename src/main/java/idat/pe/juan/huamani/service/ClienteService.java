package idat.pe.juan.huamani.service;

import java.util.List;

import idat.pe.juan.huamani.dto.ClienteDTORequest;
import idat.pe.juan.huamani.dto.ClienteDTOResponse;

public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
