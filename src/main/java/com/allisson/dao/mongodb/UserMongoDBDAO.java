package com.allisson.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.allisson.dao.UserDAO;
import com.allisson.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoIterable;

public class UserMongoDBDAO extends GenericMongoDBDAO<User> implements UserDAO {

	public UserMongoDBDAO() {
		super("users");
	}

	@Override
	public User find(Object id) {	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(id.toString()));
	    Document doc = collection.find(query).first();
	    return User.fromDocument(doc);
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		MongoIterable<Document> docs = collection.find();
		for(Document doc : docs) {
			users.add(User.fromDocument(doc));
		}
		return users;
	}

}



