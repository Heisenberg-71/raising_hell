 # CAPPEDCOLLECTIONS
 Aim:
 To implement capped collections on embedded documents in the mongodb.
 Procedure:
 1. Start.
 2. Start mongoshell using client.
 3. Create database and collection.
 4. Perform Null, Regex and Query on arrays and array on embedded
 documents.
 5. Print the output.
 6. Stop.

db.createCollection('stud');

### create capped collection with size
db.createCollection('student1',{capped:true,size:1000})
### create capped collection with max
db.createCollection('studeent',{capped:true,size:1000,max:1000})
### check for capped collection or not
db.studeent.isCapped()
db.stud.isCapped()
###  Convert normal collection into capped collection
db.runCommand({convertToCapped:'stud',size:1000})
db.stud.isCapped()
