 # LOGICALANDCOMPARISONOPERATORS
 Aim:
 To create the database and collection perform comparison and logical
 operator.
 Procedure:
 1. Start mongodb using shell.
 2. Create the Database and insert the document into collection.
 3. Perform comparison operator- $and, $or, $not, $nor 4. Perform Logical
 operator- $eq, $gt, $gte, $lte, $in, $nin, $ne
 5. Stop the program

``db.createCollection('stud');
db.stud.insertOne({'name':'venkat','regno':61,'Branch':'IT'});
db.stud.insertMany([{'name':'Selva','regno':54,'Branch':'IT'},{'name':'Barath','regno':09,'Branch':'IT'}, {'name':'JP','regno':30,'Branch':'IT'}]);``
### and
```db.stud.find({$and:[{name:'Selva'},{regno:54}]});```
### or
```db.stud.find({$or:[{name:'Selva'},{regno:10}]});```
### nor
```db.stud.find({$nor:[{name:'Selva'},{regno:4}]});```
### not
```db.stud.find({regno:{$not:{$eq:54}}});```
### equal
```db.stud.find({regno:{$eq:54}});```
### greaterthan
```db.stud.find({regno:{$gt:54}});```
### lessthan
```db.stud.find({regno:{$lt:54}});```
### greaterthanequal
```db.stud.find({regno:{$gte:54}});```
### lessthanequla
```db.stud.find({regno:{$lte:54}});```
### not equal
```db.stud.find({regno:{$ne:54}});```
### in
```db.stud.find({regno:{$in:[54]}},{id:0});```
### notin
```db.stud.find({regno:{$nin:[54]}},{id:0});```

```db.stud.find();```