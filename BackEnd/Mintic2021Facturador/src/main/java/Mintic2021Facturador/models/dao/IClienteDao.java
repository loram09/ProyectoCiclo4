package Mintic2021Facturador.models.dao;

import org.springframework.data.repository.CrudRepository;

import Mintic2021Facturador.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long >{

}
