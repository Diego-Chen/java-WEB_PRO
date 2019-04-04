/**
 * 
 */
package com.cs.mongoDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Filter;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.DeleteResult;

/**
 * @author Administrator
 *
 */
public enum MongoUtil {
	
	//单例
	instance;
	
	private static MongoClient mongoClient;
	
	static{
		System.out.print("=========MonogoDB初始化===========");
		String ip = "127.0.0.1";
		int port = 27017;
		 /** 直接登录 */
		// To directly connect to a single MongoDB server.
		// (this will not auto-discover the primary even if it's a member of a replica set)
		mongoClient = new MongoClient(ip, port);
		Builder options = new MongoClientOptions.Builder();
		options.cursorFinalizerEnabled(true);
		options.connectionsPerHost(300);
		options.connectTimeout(30000);
		options.maxWaitTime(5000);
		options.socketTimeout(0);
		options.threadsAllowedToBlockForConnectionMultiplier(5000);
		options.writeConcern(WriteConcern.SAFE);
		options.build();
		

		/** 使用URI连接信息连接 */
		/*
		MongoClientURI connectionString = new MongoClientURI("mongodb://192.168.253.10:27017,192.168.253.20:27018,192.168.253.30:27019");
		MongoClient mongoClient = new MongoClient(connectionString);
		 */

		/** Replica Set 认证登录 */
		// to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
		// 数据库URI（两个参数分别为：服务器地址、端口）
//		ServerAddress serverAddress = new ServerAddress("192.168.253.10", 27017);
//		List<ServerAddress> addressList = new ArrayList<ServerAddress>();
//		addressList.add(serverAddress);
//		// 认证信息（三个参数分别为：用户名、数据库名称、密码） 
//		MongoCredential credential = MongoCredential.createScramSha1Credential("dsp", "dsp", "shi".toCharArray());
//		List<MongoCredential> credentialList = new ArrayList<MongoCredential>();
//		credentialList.add(credential);
//		// 根据URI和认证信息获取数据库连接
//		MongoClient mongoClient = new MongoClient(addressList, credentialList);
		
		
		
		
	}
	
	
	//获取db实例，指定DB
	public MongoDatabase getDB(String dbName){
		if(dbName != null && !"".equals(dbName)){
			MongoDatabase database = mongoClient.getDatabase(dbName);
			return database;
		}
		return null;
	}
	
	
	//获取collection对象 指定collection
	public MongoCollection<Document> getCollection(String dbName,String collName){
		if(null == collName ||"".equals(collName)){
			return null;
		}
		if(null == dbName || "".equals(dbName)){
			return null;
		}
		
		MongoCollection<Document> collection = mongoClient.getDatabase(dbName).getCollection(collName);
		return collection;
	}
	
	//获取DB下的所有表名
	public List<String> getAllCollections(String dbName){
		MongoIterable<String> colls = getDB(dbName).listCollectionNames();
		List<String> _list = new ArrayList<String>();
		for(String s :colls){
			_list.add(s);
		}
		return _list;
	}
	
	
	//获取所有数据库名称列表
	public MongoIterable<String> getAllDBNames(){
		MongoIterable<String> s = mongoClient.listDatabaseNames();
		return s;
	}
	
	
	
	//删除一个数据库
	public void dropDB(String dbName){
		getDB(dbName).drop();
	}
	
	//查找对象 - 根据主键 id
	public Document findById(MongoCollection<Document> coll,String id){
		Object _idobj = null;
		_idobj = new ObjectId(id);
		Document myDoc = coll.find(Filters.eq("_id", _idobj)).first();
		return myDoc;
	}
	
	//统计数
	public int getCount(MongoCollection<Document> coll){
		int count = (int) coll.count();
		return count;
	}
	
	//条件查询
	public MongoCursor<Document> find(MongoCollection<Document> coll , Bson filter){
		return coll.find(filter).iterator();
	}
	
	
	//分页查询
	public MongoCursor<Document> findByPage(MongoCollection<Document> coll , Bson filter,int pageNo,int pageSize){
		Bson orderBy = new BasicDBObject("_id",1);
		return coll.find(filter).sort(orderBy).skip((pageNo-1)*pageSize).limit(pageSize).iterator(); 
	}
	
	
	//通过id删除
	public int deleteById(MongoCollection<Document> coll,String id){
		int count = 0;
		ObjectId _id = null;
		_id = new ObjectId(id);
		Bson filter = Filters.eq("_id", _id);
		DeleteResult deleteResult = coll.deleteOne(filter);
		count = (int)deleteResult.getDeletedCount();
		return count;
	}
	
	//更新
	public Document updateById(MongoCollection<Document> coll , String id , Document newdoc){
		ObjectId _idobj = null;
		_idobj = new ObjectId();
		Bson filter = Filters.eq("_id", _idobj);
		coll.updateOne(filter, new Document("$set",newdoc));
		return newdoc;
	}
	
	
	
	//删除连接
	public void dropCollection(String dbName ,String collName){
		getDB(dbName).getCollection(collName).drop();
	}
	
	
	
	//关闭数据库连接
	public void close(){
		if(mongoClient != null){
			mongoClient.close();
			mongoClient = null;
		}
	}
	
	
	public static void main(String[] args) {
		String dbName = "test";
		String collName = "wd_paper_scie";
		MongoCollection<Document> coll = MongoUtil.instance.getCollection(dbName, collName);
		coll.createIndex(new Document("validata",1));
		coll.createIndex(new Document("validata",8));
		coll.createIndex(new Document("id",1));
		//创建唯一索引
		coll.createIndex(new Document("ut_wos",1),new IndexOptions().unique(true));
		
		
		//索引列表
		ListIndexesIterable<Document> list = coll.listIndexes();
		for (Document document : list) {
			System.out.println("索引" + document.toJson());
		}
		
		
	}
	
	
}
