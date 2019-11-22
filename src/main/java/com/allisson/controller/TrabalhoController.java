package com.allisson.controller;

import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.dao.TrabalhoDAO;
import com.allisson.model.Trabalho;


public class TrabalhoController {

	private static Scanner sc1;
	
	public static void insert(TrabalhoDAO dao) {
		
		sc1 = new Scanner(System.in);
		
		Trabalho entidade = new Trabalho();
		System.out.println("Digite as horas semanais do trabalho:");
		Integer horasSemanais = sc1.nextInt();
		entidade.setHorasSemanais(horasSemanais);
		
		dao.insert(entidade);
		dao.close();

	}

	public static void getAll(TrabalhoDAO dao) {
		List<Trabalho> list = dao.findAll();
		for(Trabalho entidade : list) {
			System.out.println("Id: " + entidade.getId());
			System.out.println("Horas semanais: " + entidade.getHorasSemanais());
		}
		dao.close();
	}

	public static void delete(TrabalhoDAO dao) {
		int i = 0;
		sc1 = new Scanner(System.in);
		List<Trabalho> list = dao.findAll();
		
		for(Trabalho entidade : list) {
			System.out.println("\n Trabalho "+(i+1)+"\n");
			System.out.println("Id: " + entidade.getId());
			System.out.println("Horas semanais: " + entidade.getHorasSemanais());
			
			i++;
		}
		
		System.out.println("Digite o id do Trabalho a ser excluido:");
		
		int posicao = sc1.nextInt();
		System.out.println(list.get(posicao-1).getId());
		
		dao.delete(new ObjectId(list.get(posicao-1).getId().toString()));
		dao.close();
	}

}
