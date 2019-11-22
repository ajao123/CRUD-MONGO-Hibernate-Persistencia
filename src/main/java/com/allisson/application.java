package com.allisson;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.allisson.controller.DepartamentoController;
import com.allisson.controller.DependenteController;
import com.allisson.controller.FuncionarioLimpezaController;
import com.allisson.controller.PesquisadorController;
import com.allisson.controller.ProjetoController;
import com.allisson.controller.SecretarioController;
import com.allisson.controller.TrabalhoController;
import com.allisson.dao.UserDAO;
import com.allisson.dao.mongodb.DepartamentoMongoDBDAO;
import com.allisson.dao.mongodb.DependenteMongoDBDAO;
import com.allisson.dao.mongodb.FuncionarioLimpezaMongoDBDAO;
import com.allisson.dao.mongodb.PesquisadorMongoDBDAO;
import com.allisson.dao.mongodb.ProjetoMongoDBDAO;
import com.allisson.dao.mongodb.SecretarioMongoDBDAO;
import com.allisson.dao.mongodb.TrabalhoMongoDBDAO;
import com.allisson.dao.mongodb.UserMongoDBDAO;

public class application {

	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

	public static void main(String[] args) {
		
		
		UserDAO dao = new UserMongoDBDAO();
		dao04DeleteById(dao);
		

		Scanner sc1;
		Boolean sair = true;
		Integer opcao = null;

    	

    	printMenu(); 
    	
    	while(sair) {
    		sc1 = new Scanner(System.in); 
    		try {
    			System.out.println(" 23 - Ver o menu novamente");
        		opcao = sc1.nextInt();
        		
        		switch(opcao) {
        		
        			case 1:
        				
        				System.out.println("1 - Adicionar Pesquisador");
        				System.out.println("2 - Adicionar Secretario");
        				System.out.println("3 - Adicionar Funcionario de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					PesquisadorController.insert(new PesquisadorMongoDBDAO());
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.insert(new SecretarioMongoDBDAO());
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.insert(new FuncionarioLimpezaMongoDBDAO());
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        				
        				break;
        				
        			case 2:
        					
        				System.out.println("1 - Buscar Pesquisador");
        				System.out.println("2 - Buscar Secretario");
        				System.out.println("3 - Buscar Funcionario de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					
        				}else if(opcao == 2) {
        					
        					
        				}else if(opcao == 3){
        					
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        				
            			break;
            			
        			case 3:
        				
        				System.out.println("1 - Deletar Pesquisador");
        				System.out.println("2 - Deletar Secretario");
        				System.out.println("3 - Deletar Funcionario de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					PesquisadorController.delete(new PesquisadorMongoDBDAO());
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.delete(new SecretarioMongoDBDAO());
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.delete(new FuncionarioLimpezaMongoDBDAO());
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        				
            			break;
            			
        			case 4:
        				
        				System.out.println("1 - Buscar Pesquisadores");
        				System.out.println("2 - Buscar Secretarios");
        				System.out.println("3 - Buscar Funcionarios de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        					
        					PesquisadorController.getAll(new PesquisadorMongoDBDAO());
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.getAll(new SecretarioMongoDBDAO());
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.getAll(new FuncionarioLimpezaMongoDBDAO());
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        			
            			break;
            			
        			case 5:
        				
        				DepartamentoController.insert(new DepartamentoMongoDBDAO());
        				
            			break;
            			
        			case 6:
            			break;
            			
        			case 7:
        				DepartamentoController.delete(new DepartamentoMongoDBDAO());
        				
            			break;
            			
        			case 8:
        				DepartamentoController.getAll(new DepartamentoMongoDBDAO());
        				
            			break;
            			
        			case 9:
        				ProjetoController.insert(new ProjetoMongoDBDAO());
            			break;
            			
        			case 10:
        				break;
        				
        			case 11:
        				ProjetoController.delete(new ProjetoMongoDBDAO());
        				break;
        				
        			case 12:
        				ProjetoController.getAll(new ProjetoMongoDBDAO());
        				break;
        			case 13:
        				TrabalhoController.insert(new TrabalhoMongoDBDAO());
        				break;
        				
        			case 14:
        				
        				break;
        				
        			case 15:
        				TrabalhoController.delete(new TrabalhoMongoDBDAO());
        				break;
        				
        			case 16:
        				
        				TrabalhoController.getAll(new TrabalhoMongoDBDAO());
        				
        				break;
        			case 17:
        				DependenteController.insert(new DependenteMongoDBDAO());
        				break;
        			case 18:
        				break;
        			case 19:
        				DependenteController.delete(new DependenteMongoDBDAO());
        				break;
        			case 20:
        				DependenteController.getAll(new DependenteMongoDBDAO());
        				break;
        			case 21:	
        				System.out.println("\t Atualizar \n");
        				System.out.println("1 - Pesquisador");
        				System.out.println("2 - Secretario");
        				System.out.println("3 - Funcionario de Limpeza");
        				System.out.println("4 - Departamento");
        				System.out.println("5 - Dependente");
        				System.out.println("6 - Trabalho");
        				System.out.println("7 - Projeto \n");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					
        				}else if(opcao == 2) {
        					
        					
        				}else if(opcao == 3){
        					
        					
        				}else if(opcao == 4){
        					
        					
        				}else if(opcao == 5){
        					
        					
        				}else if(opcao == 6){
        					
        					
        				}else if(opcao == 7){
        					
        					
        				}
        				
        				break;
        			case 22:
        				sair = false;
        				break;
        			case 23:
        				printMenu();
        				break;
        				
        			default:
        				System.out.println("Opção inválida.");
        				break;
        				
        		
        		}
    		}catch(Exception e) {
    			System.out.println("\n \n" + "\t \t" +"Erro: Opcao Invalida."+"\n \n");
    		}
    	}

	}
	
	public static void printMenu() {
		System.out.println(" f1  - Adicionar Funcionario");
		System.out.println(" 2  - Buscar Funcionario");
		System.out.println(" f3  - Deletar Funcionario");
		System.out.println(" f4  - Buscar Funcionarios");
		System.out.println(" f5  - Adicionar Departamento");
		System.out.println(" 6  - Buscar Departamento");
		System.out.println(" f7  - Deletar Departamento");
		System.out.println(" f8  - Buscar Departamentos");
		System.out.println(" f9  - Adicionar Projeto");
		System.out.println(" 10 - Buscar Projeto");
		System.out.println(" f11 - Deletar Projeto");
		System.out.println(" f12 - Buscar Projetos");
		System.out.println(" f13 - Adicionar Trabalho");
		System.out.println(" 14 - Buscar Trabalho");
		System.out.println(" f15 - Deletar Trabalho");
		System.out.println(" f16 - Buscar Trabalhos");
		System.out.println(" f17 - Adicionar Dependente");
		System.out.println(" 18 - Buscar Dependente");
		System.out.println(" f19 - Deletar Dependente");
		System.out.println(" f20 - Buscar Dependentes");
		System.out.println(" 21 - Atualizar");
		System.out.println(" 22 - Sair do sistema");
	}
	public static void dao04DeleteById(UserDAO dao) {
		dao.delete(new ObjectId("5dd54392f707151a615480ad"));
	}	
	
	
	
	
	
	
	
	
//public static void main(String[] args) {
		
		//DependenteDAO dao = new DependenteMongoDBDAO();
	
		//PesquisadorDAO dao = new PesquisadorMongoDBDAO();
	
//		FuncionarioLimpezaDAO dao = new FuncionarioLimpezaMongoDBDAO();
	
		
//		SecretarioDAO dao = new SecretarioMongoDBDAO();
	
//		ProjetoDAO dao1 = new ProjetoMongoDBDAO();
//		TrabalhoDAO dao2 = new TrabalhoMongoDBDAO();
//	
//		dao01Inserir(dao1, dao2);
//		 dao02findById(dao);
//		 dao03Update(dao);
//		 dao04DeleteById(dao);
//		 dao05DeleteUser(dao);
//		dao06FindAll(dao1, dao2);
//		dao1.close();
//		dao2.close();
//		
//		System.out.println("Bye, Mongo DAO");
	
	
//	}

}
