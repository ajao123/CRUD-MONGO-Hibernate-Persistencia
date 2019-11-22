package com.allisson.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Projeto extends Bean{

	private String nome;
	private String periodoTempo;
	
	public Projeto() {
		super();
	}

	public Projeto(ObjectId id, String nome, String periodoTempo) {
		super(id);
		this.nome = nome;
		this.periodoTempo = periodoTempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodoTempo() {
		return periodoTempo;
	}

	public void setPeriodoTempo(String periodoTempo) {
		this.periodoTempo = periodoTempo;
	}

	@Override
	public String toJson() {
		String json = "{\"nome\" : \""+nome+"\", \"periodoTempo\" : \""+periodoTempo+"\"}";
		return json;
	}
	
	public static Projeto fromDocument(Document doc) {
		if(doc == null) return null;
		
		Projeto projeto = new Projeto();
		
		projeto.id = doc.getObjectId("_id");
		projeto.nome = doc.getString("nome");
		projeto.periodoTempo = doc.getString("periodoTempo");
		
		return projeto;
	}
	
}
