package com.allisson.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.dao.ProjetoDAO;
import com.allisson.model.Projeto;


public class ProjetoController {

	private static Scanner sc1;
	
	public static void insert(ProjetoDAO dao) {
		
		sc1 = new Scanner(System.in);
		
		Projeto entidade = new Projeto();
		
		System.out.println("Digite o nome do Projeto:");
		String nome = sc1.nextLine();
		
		System.out.println("Digite o periodo de tempo do projeto:");
		String periodoTempo = sc1.nextLine();
		
		entidade.setNome(nome);
		entidade.setPeriodoTempo(periodoTempo);
		
		dao.insert(entidade);
		dao.close();

	}

	public static void getAll(ProjetoDAO dao) {
		List<Projeto> list = dao.findAll();
		for(Projeto entidade : list) {
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Periodo de tempo: " + entidade.getPeriodoTempo());
		
		}
		dao.close();
	}

	public static void delete(ProjetoDAO dao) {
		int i = 0;
		sc1 = new Scanner(System.in);
		List<Projeto> list = dao.findAll();
		for(Projeto entidade : list) {
			System.out.println("\n Projeto "+(i+1)+"\n");
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Periodo de tempo: " + entidade.getPeriodoTempo());
			i++;
		}
		
		System.out.println("Digite o id do Projeto a ser excluido:");
		
		int posicao = sc1.nextInt();
		System.out.println(list.get(posicao-1).getId());
		
		dao.delete(new ObjectId(list.get(posicao-1).getId().toString()));
		dao.close();
	}

}
