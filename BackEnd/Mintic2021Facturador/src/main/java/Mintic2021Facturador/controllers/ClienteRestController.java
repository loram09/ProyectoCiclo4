package Mintic2021Facturador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Mintic2021Facturador.models.entity.Cliente;
import Mintic2021Facturador.models.service.IClienteService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")

public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	@GetMapping("/cliente/{Id}")
	public Cliente show(@PathVariable long Id) {
		return clienteService.findById(Id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody  Cliente cliente){
		//cliente.setCreateAt(new java.util.Date());
		this.clienteService.save(cliente);
		return cliente;	
		
	}
	
    @PutMapping("cliente/{Id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody  Cliente cliente,@PathVariable Long Id) {
    	Cliente currentCliente=this.clienteService.findById(Id);
    	currentCliente.setNombre(cliente.getNombre());
    	currentCliente.setApellido(cliente.getApellido());
    	currentCliente.setEmail(cliente.getEmail());
    	currentCliente.setTelefono(cliente.getTelefono());
    	currentCliente.setDireccion(cliente.getDireccion());
    	this.clienteService.save(currentCliente);
    	return currentCliente;
    }

	
}
