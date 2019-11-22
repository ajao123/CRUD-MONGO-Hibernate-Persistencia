package com.allisson.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.allisson.dao.ProjetoDAO;
import com.allisson.dao.UserDAO;
import com.allisson.model.Projeto;
import com.allisson.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoIterable;

public class ProjetoMongoDBDAO extends GenericMongoDBDAO<Projeto> implements ProjetoDAO {

	public ProjetoMongoDBDAO() {
		super("projetos");
	}
	
	@Override
	public Projeto find(Object id) {	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(id.toString()));
	    Document doc = collection.find(query).first();
	    return Projeto.fromDocument(doc);
	}
	
	@Override
	public List<Projeto> findAll() {
		List<Projeto> Projetos = new ArrayList<Projeto>();
		MongoIterable<Document> docs = collection.find();
		for(Document doc : docs) {
			Projetos.add(Projeto.fromDocument(doc));
		}
		return Projetos;
	}

}

