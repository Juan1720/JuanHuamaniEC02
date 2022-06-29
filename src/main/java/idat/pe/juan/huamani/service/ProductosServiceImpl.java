package idat.pe.juan.huamani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.pe.juan.huamani.dto.ProductosDTORequest;
import idat.pe.juan.huamani.dto.ProductosDTOResponse;
import idat.pe.juan.huamani.model.Productos;
import idat.pe.juan.huamani.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	private ProductosRepository repository;

	@Override
	public void guardarProducto(ProductosDTORequest productos) {
		
		Productos p = new Productos();
		p.setProducto(productos.getNombre());
		p.setDescripcion(productos.getDescripcionProducto());
		p.setPrecio(productos.getPrecioProducto());
		p.setStock(productos.getStockProducto());
		repository.save(p);
		
	}

	@Override
	public void actualizarProducto(ProductosDTORequest productos) {
		
		Productos p = new Productos();
		p.setIdProducto(productos.getId());
		p.setProducto(productos.getNombre());
		p.setDescripcion(productos.getDescripcionProducto());
		p.setPrecio(productos.getPrecioProducto());
		p.setStock(productos.getStockProducto());
		repository.saveAndFlush(p);

	}

	@Override
	public void eliminarProducto(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<ProductosDTOResponse> listarProducto() {
		
		List<ProductosDTOResponse> listar = new ArrayList<>();
		ProductosDTOResponse dto = null;
		List<Productos> p = repository.findAll();
		
		for(Productos productos :p) {
			
			dto = new ProductosDTOResponse();
			dto.setId(productos.getIdProducto());
			dto.setNombre(productos.getProducto());
			dto.setDescripcionProducto(productos.getDescripcion());
			dto.setPrecioProducto(productos.getPrecio());
			dto.setStockProducto(productos.getStock());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public ProductosDTOResponse obtenerProductoId(Integer id) {
		
		Productos productos  = repository.findById(id).orElse(null);
		ProductosDTOResponse dto = new ProductosDTOResponse();
		dto.setId(productos.getIdProducto());
		dto.setNombre(productos.getProducto());
		dto.setDescripcionProducto(productos.getDescripcion());
		dto.setPrecioProducto(productos.getPrecio());
		dto.setStockProducto(productos.getStock());
		return dto;
	}

}
