package com.allisson.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.dao.DependenteDAO;
import com.allisson.model.Dependente;

public class DependenteController {

	private static Scanner sc1;
	
	public static void insert(DependenteDAO dao) {
		
		sc1 = new Scanner(System.in);
		
		Dependente entidade = new Dependente();
		
		System.out.println("Digite o nome:");
		String nome = sc1.nextLine();
		
		System.out.println("Digite o sexo:");
		String sexo = sc1.nextLine();
		
		System.out.println("Digite a data de nascimento:");
		LocalDate dataNascimento = LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
		
		System.out.println("Digite o grau de parentesco:");
		String grauParentesco = sc1.nextLine();
		
		entidade.setNome(nome);
		entidade.setSexo(sexo);
		entidade.setDataNascimento(dataNascimento);
		entidade.setGrauParentesco(grauParentesco);
		
		dao.insert(entidade);
		dao.close();

	}

	public static void getAll(DependenteDAO dao) {
		List<Dependente> list = dao.findAll();
		for(Dependente entidade : list) {
			
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Data de Nascimento: " + entidade.getDataNascimento());
			System.out.println("Grau de Parentesco: " + entidade.getGrauParentesco());

		}
		dao.close();
	}

	public static void delete(DependenteDAO dao) {
		int i = 0;
		sc1 = new Scanner(System.in);
		List<Dependente> list = dao.findAll();
		for(Dependente entidade : list) {
			System.out.println("\n Dependente "+(i+1)+"\n");
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Data de Nascimento: " + entidade.getDataNascimento());
			System.out.println("Grau de Parentesco: " + entidade.getGrauParentesco());

			i++;
		}
		
		System.out.println("Digite o id do Dependente a ser excluido:");
		
		int posicao = sc1.nextInt();
		System.out.println(list.get(posicao-1).getId());
		
		dao.delete(new ObjectId(list.get(posicao-1).getId().toString()));
		dao.close();
	}

}
