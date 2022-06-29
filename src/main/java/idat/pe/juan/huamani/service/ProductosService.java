package idat.pe.juan.huamani.service;

import java.util.List;

import idat.pe.juan.huamani.dto.ProductosDTORequest;
import idat.pe.juan.huamani.dto.ProductosDTOResponse;

public interface ProductosService {
	
	void guardarProducto(ProductosDTORequest productos);
	void actualizarProducto(ProductosDTORequest productos);
	void eliminarProducto(Integer id);
	List<ProductosDTOResponse> listarProducto();
	ProductosDTOResponse obtenerProductoId(Integer id);

}
