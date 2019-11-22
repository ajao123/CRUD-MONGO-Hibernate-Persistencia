package com.allisson.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.dao.SecretarioDAO;
import com.allisson.model.Secretario;

public class SecretarioController {
	
private static Scanner sc1;
	
	public static void insert(SecretarioDAO dao) {
		
		sc1 = new Scanner(System.in);
		
		Secretario entidade = new Secretario();
		
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
		
		System.out.println("Digite seu grau de escolaridade:");
		String grauEscolaridade = sc1.nextLine();
		
		entidade.setNome(nome);
		entidade.setEndereco(endereco);
		entidade.setSexo(sexo);
		entidade.setDataNascimento(nascimento);
		entidade.setSalario(salario);
		entidade.setGrauEscolaridade(grauEscolaridade);
		
		dao.insert(entidade);
		dao.close();

	}

	public static void getAll(SecretarioDAO dao) {
		List<Secretario> list = dao.findAll();
		for(Secretario entidade : list) {
			System.out.println("\n \nId: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Endereco: " + entidade.getEndereco());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Salario: "+entidade.getSalario());
			System.out.println("Grau de Escolaridade: "+entidade.getGrauEscolaridade());
		
		}
		dao.close();
	}

	public static void delete(SecretarioDAO dao) {
		int i = 0;
		sc1 = new Scanner(System.in);
		List<Secretario> list = dao.findAll();
		for(Secretario entidade : list) {
			System.out.println("\n Secretario "+(i+1)+"\n");
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Endereco: " + entidade.getEndereco());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Salario: "+entidade.getSalario());
			System.out.println("Grau de Escolaridade: "+entidade.getGrauEscolaridade());
			i++;
		}
		
		System.out.println("Digite o id do Secretario a ser excluido:");
		
		int posicao = sc1.nextInt();
		System.out.println(list.get(posicao-1).getId());
		
		dao.delete(new ObjectId(list.get(posicao-1).getId().toString()));
		dao.close();
	}
	
}
