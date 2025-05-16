 # CURSORS
 To implement cursors on embedded documents in mongodb.
 Procedure:
 1. Start.
 2. Start mongoshell using client.
 3. Create database and collection.
 4. Perform cursors on embedded documents.
 5. Print the output.
 6. Stop

db.createCollection('stud');
db.stud.insertOne({'name':'venkat','age':18});
db.stud.insertMany([{'name':'Selva','age':null},
{'name':'Barath'}, {'name':'JP','age':19}]);

## limit
db.stud.find().limit(2);

## skip
db.stud.find().skip(1);

## limit and skip
db.stud.find().limit(1).skip(2)

## count
db.stud.count()