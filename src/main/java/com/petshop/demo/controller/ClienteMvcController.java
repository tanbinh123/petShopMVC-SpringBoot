package com.petshop.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petshop.demo.exception.naoEncontradoException;
import com.petshop.demo.model.ClienteEntity;
import com.petshop.demo.service.ClienteService;

@Controller
@RequestMapping("/")
public class ClienteMvcController 
{
	@Autowired
	ClienteService service;
	
//	getTodosClientes() – retrona a lista de todos os clientes e o seu caminho mapeado é "/" sendo o caminho default da aplicação 
	@RequestMapping
	public String getTodosClientes(Model model) 
	{
		List<ClienteEntity> lista = service.getTodosClientes();

		model.addAttribute("clientes", lista);
		return "lista-clientes";
	}

	
	/*
	 *editaClientePorId() – Esse é usado tanto para adicionar com editar um cliente já existente. Usa-se o HTML para 
	 *ambas operações. Se há um cliente ID então ocliente é editado, senão um novo criente é criado
	 */
	@RequestMapping(path = {"/edita", "/edita/{id}"})
	public String editaClientePorId(Model model, @PathVariable("id") Optional<Long> id) 
							throws naoEncontradoException 
	{
		if (id.isPresent()) {
			ClienteEntity cliente = service.getClientePorId(id.get());
			model.addAttribute("cliente", cliente);
		} else {
			model.addAttribute("cliente", new ClienteEntity());
		}
		return "adiciona-edita-cliente";
	}
	
    //deletaClientePorId() – Uma requisição de URL para deletar um cliente pelo ID
	@RequestMapping(path = "/deleta/{id}")
	public String deletaClientePorId(Model model, @PathVariable("id") Long id) 
							throws naoEncontradoException 
	{
		service.deletaClientePorId(id);
		return "redirect:/";
	}

	/*
	 * criaOuAtualizaCliente() – Este metodo POST HTTP faz uma request que é usado para criar ou atualizar o cliente 
	 * a criação ouh atualização depende da presença de ID de um cliente no Model
	 * */
	@RequestMapping(path = "/criaCliente", method = RequestMethod.POST)
	public String criaOuAtualizaCliente(ClienteEntity cliente) 
	{
		service.criaOuAtualizaCliente(cliente);
		return "redirect:/";
	}
}
