package com.allisson.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.allisson.dao.DependenteDAO;
import com.allisson.dao.FuncionarioLimpezaDAO;
import com.allisson.model.Dependente;
import com.allisson.model.Funcionario;
import com.allisson.model.FuncionarioLimpeza;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoIterable;

public class FuncionarioLimpezaMongoDBDAO extends FuncionarioMongoDBDAO<FuncionarioLimpeza> implements FuncionarioLimpezaDAO {

	public FuncionarioLimpezaMongoDBDAO() {
		super("funcionariosLimpeza");
	}
	
	@Override
	public FuncionarioLimpeza find(Object id) {	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(id.toString()));
	    Document doc = collection.find(query).first();
	    return FuncionarioLimpeza.fromDocument(doc);
	}
	
	@Override
	public List<FuncionarioLimpeza> findAll() {
		List<FuncionarioLimpeza> FuncionarioLimpezas = new ArrayList<FuncionarioLimpeza>();
		MongoIterable<Document> docs = collection.find();
		for(Document doc : docs) {
			FuncionarioLimpezas.add(FuncionarioLimpeza.fromDocument(doc));
		}
		return FuncionarioLimpezas;
	}


}

