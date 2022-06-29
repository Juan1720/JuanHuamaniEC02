package idat.pe.juan.huamani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.pe.juan.huamani.dto.BodegaDTORequest;
import idat.pe.juan.huamani.dto.BodegaDTOResponse;
import idat.pe.juan.huamani.model.Bodega;
import idat.pe.juan.huamani.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository repository;
	
	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		b.setNombre(bodega.getBodega());
		b.setDireccion(bodega.getDireccionBodega());
		repository.save(b);
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		b.setIdBodega(bodega.getId());
		b.setNombre(bodega.getBodega());
		b.setDireccion(bodega.getDireccionBodega());
		repository.saveAndFlush(b);

	}

	@Override
	public void eliminarBodega(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		
		List<BodegaDTOResponse> listar = new ArrayList<>();
		BodegaDTOResponse dto = null;
		List<Bodega> b = repository.findAll();
		for(Bodega bodega : b) {
			dto = new BodegaDTOResponse();
			dto.setId(bodega.getIdBodega());
			dto.setBodega(bodega.getNombre());
			dto.setDireccionBodega(bodega.getDireccion());
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		
		Bodega bodega = repository.findById(id).orElse(null);
		BodegaDTOResponse dto = new BodegaDTOResponse();
		dto.setId(bodega.getIdBodega());
		dto.setBodega(bodega.getNombre());
		dto.setDireccionBodega(bodega.getDireccion());	
		return dto;
	}
}
