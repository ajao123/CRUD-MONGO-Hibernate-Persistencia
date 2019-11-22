package com.allisson.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Pesquisador extends Funcionario{

	private String areaAtuacao;

	public Pesquisador() {
		
	}

	public Pesquisador(ObjectId id, String nome, String endereco, String sexo, LocalDate dataNascimento,
			Double salario, String areaAtuacao) {
		super(id, nome, endereco, sexo, dataNascimento, salario);
		
		this.areaAtuacao = areaAtuacao;
	}
	
	

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}


	@Override
	public String toJson() {
		String json = "{\"areaAtuacao\" : \""+areaAtuacao+"\","
					+ "\"nome\" : \""+nome+"\", "
					+ "\"endereco\" : \""+endereco+"\", "
					+ "\"dataNascimento\" : \""+dataNascimento+"\", "
					+ "\"sexo\" : \""+sexo+"\", "
					+ "\"salario\" : \""+salario+"\"}";
		return json;
	}
	

	public static Pesquisador fromDocument(Document doc) {
		
		if(doc == null) return null;
		
		Pesquisador pesquisador = new Pesquisador();
		
		pesquisador.id = doc.getObjectId("_id");
		pesquisador.nome = doc.getString("nome");
		pesquisador.endereco = doc.getString("endereco");
		pesquisador.sexo  = doc.getString("sexo");
		pesquisador.areaAtuacao = doc.getString("areaAtuacao");
		pesquisador.salario = Double.parseDouble(doc.getString("salario"));
		pesquisador.dataNascimento = LocalDate.now();
		
		
		return pesquisador;
	}


}
