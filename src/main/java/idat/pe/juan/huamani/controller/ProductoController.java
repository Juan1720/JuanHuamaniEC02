package idat.pe.juan.huamani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idat.pe.juan.huamani.dto.ProductosDTORequest;
import idat.pe.juan.huamani.dto.ProductosDTOResponse;
import idat.pe.juan.huamani.service.ProductosService;

@Controller
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	private ProductosService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ProductosDTOResponse>> listar(){
		return new ResponseEntity<List<ProductosDTOResponse>>(service.listarProducto(), HttpStatus.OK) ;
		
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductosDTORequest productos) {
		service.guardarProducto(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProductosDTOResponse producto = service.obtenerProductoId(id);
		if(producto != null) {
			service.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ProductosDTORequest productos){
		
		ProductosDTOResponse p = service.obtenerProductoId(productos.getId());
		if(p != null) {
			service.actualizarProducto(productos);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductosDTOResponse> obtenerId(@PathVariable Integer id){
		
		ProductosDTOResponse p = service.obtenerProductoId(id);
		if(p != null) {
			return new ResponseEntity<ProductosDTOResponse>(service.obtenerProductoId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<ProductosDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	

}
