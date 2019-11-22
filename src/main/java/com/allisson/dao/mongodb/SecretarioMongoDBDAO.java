package com.allisson.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.allisson.dao.DependenteDAO;
import com.allisson.dao.SecretarioDAO;
import com.allisson.model.Dependente;
import com.allisson.model.Secretario;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoIterable;

public class SecretarioMongoDBDAO extends FuncionarioMongoDBDAO<Secretario> implements SecretarioDAO {

	public SecretarioMongoDBDAO() {
		super("secretarios");
	}
	
	@Override
	public Secretario find(Object id) {	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(id.toString()));
	    Document doc = collection.find(query).first();
	    return Secretario.fromDocument(doc);
	}
	
	@Override
	public List<Secretario> findAll() {
		List<Secretario> Secretarios = new ArrayList<Secretario>();
		MongoIterable<Document> docs = collection.find();
		for(Document doc : docs) {
			Secretarios.add(Secretario.fromDocument(doc));
		}
		return Secretarios;
	}


}

