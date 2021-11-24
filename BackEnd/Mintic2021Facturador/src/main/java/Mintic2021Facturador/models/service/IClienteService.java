package Mintic2021Facturador.models.service;

import java.util.List;

import Mintic2021Facturador.models.entity.Cliente;

public interface IClienteService {

	public List <Cliente> findAll();
	
	public Cliente findById(Long Id);
	
	public void save(Cliente cliente);
	
	public void delete(Cliente cliente);

	
}
