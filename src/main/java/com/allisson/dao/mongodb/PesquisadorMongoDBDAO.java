package com.allisson.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.allisson.dao.DependenteDAO;
import com.allisson.dao.PesquisadorDAO;
import com.allisson.model.Dependente;
import com.allisson.model.Pesquisador;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoIterable;

public class PesquisadorMongoDBDAO extends FuncionarioMongoDBDAO<Pesquisador> implements PesquisadorDAO {

	public PesquisadorMongoDBDAO() {
		super("pesquisadores");
	}
	
	@Override
	public Pesquisador find(Object id) {	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(id.toString()));
	    Document doc = collection.find(query).first();
	    return Pesquisador.fromDocument(doc);
	}
	
	@Override
	public List<Pesquisador> findAll() {
		List<Pesquisador> Pesquisadores = new ArrayList<Pesquisador>();
		MongoIterable<Document> docs = collection.find();
		for(Document doc : docs) {
			Pesquisadores.add(Pesquisador.fromDocument(doc));
		}
		return Pesquisadores;
	}

}

