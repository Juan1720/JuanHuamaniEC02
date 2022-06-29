package idat.pe.juan.huamani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.pe.juan.huamani.dto.UsuarioDTORequest;
import idat.pe.juan.huamani.dto.UsuarioDTOResponse;
import idat.pe.juan.huamani.model.Usuario;
import idat.pe.juan.huamani.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {
		Usuario u = new Usuario();
		u.setUsuario(usuario.getNombreUsuario());
		u.setPassword(usuario.getPasswordUsuario());
		u.setRol(usuario.getPasswordUsuario());
		repository.save(u);
	}

	@Override
	public void actualizaUsuario(UsuarioDTORequest usuario) {
		
		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuario());
		u.setUsuario(usuario.getNombreUsuario());
		u.setPassword(usuario.getPasswordUsuario());
		u.setRol(usuario.getPasswordUsuario());
		repository.saveAndFlush(u);

	}

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<UsuarioDTOResponse> listarUsuario() {
		
		List<UsuarioDTOResponse> listar = new ArrayList<>();
		UsuarioDTOResponse dto = null;
		List<Usuario> u = repository.findAll();
		for(Usuario usuario : u) {
			dto = new UsuarioDTOResponse();
			dto.setNombreUsuario(usuario.getUsuario());
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		Usuario usuario = repository.findById(id).orElse(null);
		UsuarioDTOResponse dto = new UsuarioDTOResponse();
		dto.setNombreUsuario(usuario.getUsuario());
		return dto;
	}

}
