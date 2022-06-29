package idat.pe.juan.huamani.service;

import java.util.List;

import idat.pe.juan.huamani.dto.UsuarioDTORequest;
import idat.pe.juan.huamani.dto.UsuarioDTOResponse;

public interface UsuarioService {
	
	void guardarUsuario(UsuarioDTORequest usuario);
	void actualizaUsuario(UsuarioDTORequest usuario);
	void eliminarUsuario(Integer id);
	List<UsuarioDTOResponse> listarUsuario();
	UsuarioDTOResponse obtenerUsuarioId(Integer id);

}
