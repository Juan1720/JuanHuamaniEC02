package idat.pe.juan.huamani.service;

import java.util.List;

import idat.pe.juan.huamani.dto.BodegaDTORequest;
import idat.pe.juan.huamani.dto.BodegaDTOResponse;

public interface BodegaService {
	
	void guardarBodega(BodegaDTORequest bodega);
	void actualizarBodega(BodegaDTORequest bodega);
	void eliminarBodega(Integer id);
	List<BodegaDTOResponse> listarBodega();
	BodegaDTOResponse obtenerBodegaId(Integer id);

}
