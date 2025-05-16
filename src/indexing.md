# indexing
To implement indexing on embedded documents in mongodb.
 Procedure:
 1. Start.
 2. Start mongoshell using client.
 3. Create database and collection.
 4. Perform indexing on embedded documents.
 5. Print the output.
 6. Stop.

db.createCollection('stud');
db.stud.insertOne({'name':'venkat','age':18});
db.stud.insertMany([{'name':'Selva','age':null},
{'name':'Barath'}, {'name':'JP','age':19}]);
### createIndex
db.stud.createIndex({name:1});
db.stud.createIndex({name:1,age:-1})
### getindex
db.stud.getIndexes()
### dropIndex
db.stud.dropIndex({name:1})
### Singleindexing:
db.n.createIndex({name:1})
### CompoundIndexing:
db.n.createIndex({name:1,age:1})
### TextIndexing:
db.n.createIndex({name:"text"})
### HashedIndexing:
db.n.createIndex({_id:"hashed"})
### WildcardIndexing:
db.n.createIndex({"name.$**":1})
