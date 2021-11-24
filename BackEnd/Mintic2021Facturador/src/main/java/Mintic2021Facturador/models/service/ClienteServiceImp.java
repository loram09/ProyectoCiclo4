package Mintic2021Facturador.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Mintic2021Facturador.models.dao.IClienteDao;
import Mintic2021Facturador.models.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long Id) {
		return clienteDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional
	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
		
	}

	
}
