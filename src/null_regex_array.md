# NULLOPERATOR,REGEXANDQUERYONARRAYSANDARRAYONEMBEDDEDDOCUMENTS
 Aim:
 To implement the Null, Regex, Query on arrays and array on embedded
 documents in the mongodb.
 Procedure:
 1. Start
 2. Start mongo shell using client.
 3. Create database and collection.
 4. Perform Null, Regex and Query on arrays and array on embedded
 documents.
 5. Print the output.
 6. Stop
 
```db.createCollection('stud'); db.stud.insertOne({'name':'venkat','age':18}); db.stud.insertMany([{'name':'Selva','age':null},{'name':'Barath'}, {'name':'JP','age':19}]);```
### null
```db.stud.find({age:null});```
### exists
```db.stud.find({age:{$exists:false}});```
### Regex
db.stud.find({name:{$regex:"a$"}})
db.stud.find({name:{$regex:"t$"}})
db.stud.find({name:{$regex:"^J"}})
db.stud.insert({"name":"Anand","age":19})
db.stud.find({name:{$regex:"^A","$options":"1"}})
db.stud.find({name:{$regex:"^S","$options":"1"}})
db.stud.find({name:{$regex:"^S","$options":"5"}})
### insertMany
db.v.insertMany([{fruits:["apple","pineapple","grapes"]},{fruits:["apple","mango"]},{fruits:["apple","pineapple","straw berry"]}])
### size
db.v.find({fruits:{$size:2}})
## all
db.v.find({fruits:{$all:["apple"]}})
### insertMany
db.v.insertMany([{ item:"journal",instock:[{warehouse:"A",qty:5},{warehouse:"C",qty:15}]},{item:"notebook",instock:[{warehouse:"C",qty:5}]},{item:"paper",instock:[{warehouse:"A",qty:60},{warehouse:"B",qty:15}]}]);
### instock
db.v.find({instock:{warehouse:"A",qty:5}})
### elematch
db.v.find({instock:{$elemMatch:{qty:{$gt:10,$lte:20}}}})
