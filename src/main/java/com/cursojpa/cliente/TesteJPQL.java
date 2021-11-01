package com.cursojpa.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cursojpa.cliente.model.Cliente;

public class TesteJPQL {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
//		String jpql = "select c from Cliente c";
//		TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class);
//		List<Cliente> listaCliente = typedQuery.getResultList();
//		
//		for (Cliente cliente: listaCliente) {
//			System.out.println(cliente.getNome());
//		}
		
		String jpql = "select c from Cliente c where id = :idCliente";
		int idCliente = 5;
		
		TypedQuery<Cliente> typedQuery = entityManager
					.createQuery(jpql, Cliente.class)
					.setParameter("idCliente", idCliente);
		List<Cliente> listaCliente = typedQuery.getResultList();
		
		for (Cliente cliente: listaCliente) {
			System.out.println(cliente.getNome());
		}
		
		
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
}
