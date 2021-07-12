package com.petshop.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petshop.demo.exception.naoEncontradoException;
import com.petshop.demo.model.ClienteEntity;
import com.petshop.demo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repositorio;
	
	public List<ClienteEntity> getTodosClientes()
	{
		List<ClienteEntity> resultado = (List<ClienteEntity>) repositorio.findAll();
		
		if(resultado.size() > 0) {
			return resultado;
		} else {
			return new ArrayList<ClienteEntity>();
		}
	}
	
	public ClienteEntity getClientePorId(Long id) throws naoEncontradoException 
	{
		Optional<ClienteEntity> cliente = repositorio.findById(id);
		
		if(cliente.isPresent()) {
			return cliente.get();
		} else {
			throw new naoEncontradoException("Não encontrado cliente com esse id");
		}
	}
						 
	public ClienteEntity criaOuAtualizaCliente(ClienteEntity entitidade) 
	{
		if(entitidade.getId()  == null) 
		{
			entitidade = repositorio.save(entitidade);
			
			return entitidade;
		} 
		else 
		{
			Optional<ClienteEntity> cliente = repositorio.findById(entitidade.getId());
			
			if(cliente.isPresent()) 
			{
				ClienteEntity novaEntitidade= cliente.get();
				novaEntitidade.setNome(entitidade.getNome());
				novaEntitidade.setSobrenome(entitidade.getSobrenome());
				novaEntitidade.setBrinquedo(entitidade.getBrinquedo());
				novaEntitidade.setEmail(entitidade.getEmail());
				novaEntitidade= repositorio.save(novaEntitidade);
				
				return novaEntitidade;
			} else {
				entitidade = repositorio.save(entitidade);		
				return entitidade;
			}
		}
	} 
	
	public void deletaClientePorId(Long id) throws naoEncontradoException 
	{
		Optional<ClienteEntity> cliente = repositorio.findById(id);
		
		if(cliente.isPresent()) 
		{
			repositorio.deleteById(id);
		} else {
			throw new naoEncontradoException("Não encontrado cliente com esse id");
		}
	} 
}