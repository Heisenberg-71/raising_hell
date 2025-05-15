 Aim:
 To create the database and collection to perform CRUD operations.
 Procedure:
 ● Start mongodb using shell.
 ● Create the Database and create an employee collection.
 ● Insert the documents into the collection.
 ● Perform the CRUD operations– create, read, update & delete.
 ● Stopthe program
# create
db.createCollection('stud');
# insert
db.stud.insertOne({'name':'venkat','regno':61,'Branch':'IT'});
# insert many
db.stud.insertMany([{'name':'Selva','regno':54,'Branch':'IT'},
 {'name':'Barath','regno':09,'Branch':'IT'}, {'name':'JP','regno':30,'Branch':'IT'}]);
# execute query
db.stud.find()
# Projection
db.stud.find({'regno':{$ne:9}},{'name':1});
# update one
db.stud.updateOne({'name':'vankat'},{$set:{'regno':60}});
# update max
db.stud.update({'name':'Selva'},{$max:{'regno':50}});
# update min
db.stud.update({'name':'Selva'},{$min:{'regno':5}});
# update mul
db.stud.update({'name':'Selva'},{$mul:{'regno':2}});
# update inc
db.stud.update({'name':'Selva'},{$inc:{'regno':2}});
# update rename
db.stud.update({'regno':12},{$rename:{'name':'studname'}});
# delete
db.stud.deleteOne({'name':'vankat','regno':61,'Branch':'IT'});
# read
db.stud.find();