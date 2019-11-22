package com.allisson.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Trabalho extends Bean{

	private Integer horasSemanais;

	public Trabalho() {
		super();
	}

	public Trabalho(ObjectId id, Integer horasSemanais) {
		super(id);
		this.horasSemanais = horasSemanais;
	}

	public Integer getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(Integer horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	@Override
	public String toJson() {
		String json = "{\"horasSemanais\" : \""+horasSemanais+"\"}";
		return json;
	}
	
	public static Trabalho fromDocument(Document doc) {
		if(doc == null) return null;
		
		Trabalho trabalho = new Trabalho();
		
		trabalho.id = doc.getObjectId("_id");
		trabalho.horasSemanais = Integer.parseInt(doc.getString("horasSemanais"));
	
		
		return trabalho;
	}
	
}
