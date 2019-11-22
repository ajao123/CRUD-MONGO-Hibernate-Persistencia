package com.allisson.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.dao.PesquisadorDAO;
import com.allisson.model.Pesquisador;

public class PesquisadorController {
	
private static Scanner sc1;
	
	public static void insert(PesquisadorDAO dao) {
		
		sc1 = new Scanner(System.in);
		
		Pesquisador entidade = new Pesquisador();
		
		System.out.println("Digite seu nome :");
		String nome = sc1.nextLine();
		
		System.out.println("Digite seu endereço :");
		String endereco = sc1.nextLine();

		
		System.out.println("Digite seu sexo :");
		String sexo = sc1.nextLine();
		
		
		System.out.println("Digite sua data de nascimento:");
		LocalDate nascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
		
		System.out.println("Digite o seu salario:");
		Double salario = sc1.nextDouble();
		sc1.nextLine();
		
		System.out.println("Digite a Area de atuacao:");
		String atuacao = sc1.nextLine();
		
		entidade.setNome(nome);
		entidade.setEndereco(endereco);
		entidade.setSexo(sexo);
		entidade.setDataNascimento(nascimento);
		entidade.setSalario(salario);
		entidade.setAreaAtuacao(atuacao);
		
		dao.insert(entidade);
		dao.close();

	}

	public static void getAll(PesquisadorDAO dao) {
		List<Pesquisador> list = dao.findAll();
		for(Pesquisador entidade : list) {
			System.out.println("\n \nId: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Endereco: " + entidade.getEndereco());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Salario: "+entidade.getSalario());
			System.out.println("Area de Atuacao: "+entidade.getAreaAtuacao());
		
		}
		dao.close();
	}

	public static void delete(PesquisadorDAO dao) {
		int i = 0;
		sc1 = new Scanner(System.in);
		List<Pesquisador> list = dao.findAll();
		for(Pesquisador entidade : list) {
			System.out.println("\n Pesquisador "+(i+1)+"\n");
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Endereco: " + entidade.getEndereco());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Salario: "+entidade.getSalario());
			System.out.println("Area de Atuacao: "+entidade.getAreaAtuacao());
			i++;
		}
		
		System.out.println("Digite o id do Pesquisador a ser excluido:");
		
		int posicao = sc1.nextInt();
		System.out.println(list.get(posicao-1).getId());
		
		dao.delete(new ObjectId(list.get(posicao-1).getId().toString()));
		dao.close();
	}
	
}
