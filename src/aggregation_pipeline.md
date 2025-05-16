 # AGGREGATIONPIPELINE
 Aim:
 To implement aggregation pipeline on embedded documents in mongodb.
 Procedure:
 1. Start
 2. Start mongoshell using client.
 3. Create database and collection.
 4. Perform aggregation pipeline on embedded documents.
 5. Print the output.
 6. Stop.

### data
db.employees.insertMany([{employeeId: 1001,firstName: "John",lastName: "Doe",
        departmentId: 1,
        gender: "male",
        position: "HR Manager",
        salary: 60000,
        hireDate: new Date("2020-01-15")
    },
    {
        employeeId: 1002,
        firstName: "Jane",
        lastName: "Smith",
        departmentId: 2,
        gender: "male",
        position: "Software Engineer",
        salary: 80000,
        hireDate: new Date("2019-08-22")
    },
    {
        employeeId: 1003,
        firstName: "Bob",
        lastName: "Johnson",
        departmentId: 3,
        gender: "male",
        position: "Sales Executive",
        salary: 70000,
        hireDate: new Date("2021-03-10")
    }
])
### $project
db.employees.aggregate({'$project':{'_id':1}});
### group with sum
db.employees.aggregate([{$group:{_id:'$position',totalEmployees:{$sum:1}}}])
### sort
db.employees.aggregate([{$sort:{salary:1}}])
### match
db.employees.aggregate([{$match:{firstName:'Jane'}}])
### match with $group
db.employees.aggregate([{$match:{gender:'male'}},{$group:{_id:'$position',totalEmployees:{$sum:1}}}])
### add
db.employees.aggregate([{$project:{gender:'male',total:{$add:['$employeeId','$salary']}}}])
### subtract
db.employees.aggregate([{$project:{gender:'male',total:{$subtract:['$employeeId','$salary']}}}])
### limit
db.employees.aggregate({'$limit':2})
### skip
db.employees.aggregate({'$skip':2})
### unwind
db.employees.aggregate({'$unwind':'$firstName'})