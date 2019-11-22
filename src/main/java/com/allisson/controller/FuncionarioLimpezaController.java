package com.allisson.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.dao.FuncionarioLimpezaDAO;
import com.allisson.model.FuncionarioLimpeza;

public class FuncionarioLimpezaController {
	
private static Scanner sc1;
	
	public static void insert(FuncionarioLimpezaDAO dao) {
		
		sc1 = new Scanner(System.in);
		
		FuncionarioLimpeza entidade = new FuncionarioLimpeza();
		
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
		
		System.out.println("Digite o seu cargo:");
		String cargo = sc1.nextLine();
		
		System.out.println("Digite a sua jornada de trabalho:");
		String jornadaTrabalho = sc1.nextLine();
		
		entidade.setNome(nome);
		entidade.setEndereco(endereco);
		entidade.setSexo(sexo);
		entidade.setDataNascimento(nascimento);
		entidade.setSalario(salario);
		entidade.setCargo(cargo);
		entidade.setJornadaTrabalho(jornadaTrabalho);
		
		dao.insert(entidade);
		dao.close();

	}

	public static void getAll(FuncionarioLimpezaDAO dao) {
		List<FuncionarioLimpeza> list = dao.findAll();
		for(FuncionarioLimpeza entidade : list) {
			System.out.println("\n \nId: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Endereco: " + entidade.getEndereco());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Salario: "+entidade.getSalario());
			System.out.println("Cargo: "+entidade.getCargo());
			System.out.println("Jornada de Trabalho: "+entidade.getJornadaTrabalho());
		
		}
		dao.close();
	}

	public static void delete(FuncionarioLimpezaDAO dao) {
		int i = 0;
		sc1 = new Scanner(System.in);
		List<FuncionarioLimpeza> list = dao.findAll();
		for(FuncionarioLimpeza entidade : list) {
			System.out.println("\n Funcionario "+(i+1)+"\n");
			System.out.println("Id: " + entidade.getId());
			System.out.println("Nome: " + entidade.getNome());
			System.out.println("Endereco: " + entidade.getEndereco());
			System.out.println("Sexo: " + entidade.getSexo());
			System.out.println("Salario: "+entidade.getSalario());
			System.out.println("Cargo: "+entidade.getCargo());
			System.out.println("Jornada de Trabalho: "+entidade.getJornadaTrabalho());
			i++;
		}
		
		System.out.println("Digite o id do Funcionario da Limpeza a ser excluido:");
		
		int posicao = sc1.nextInt();
		System.out.println(list.get(posicao-1).getId());
		
		dao.delete(new ObjectId(list.get(posicao-1).getId().toString()));
		dao.close();
	}
	
}
