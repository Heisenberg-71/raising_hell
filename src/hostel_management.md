db.students.insertMany([{name:"Anjali Mehra",roll_no:"2023EE105",room_id:110,hostel_id:"B-block",gender:"female",admission_date:new Date("2023-07-15"),contact:"9123456789"},{name:"Rohit Sharma",roll_no:"2023ME203",room_id:115,hostel_id:"B-block",gender:"male",admission_date:new Date("2023-07-16"),contact:"9876543210"},{name:"Priya Singh",roll_no:"2023CS301",room_id:120,hostel_id:"A-block",gender:"female",admission_date:new Date("2023-07-17"),contact:"9988776655"},{name:"Aman Verma",roll_no:"2023CE401",room_id:125,hostel_id:"C-block",gender:"male",admission_date:new Date("2023-07-18"),contact:"9112233445"}]);


db.students.find({ hostel_id:"B-block" });


db.students.aggregate([{$group:{_id:"$hostel_id",student_count:{$sum:1}}}]);


db.students.find({ admission_date: { $lt: new Date("2023-08-01") } });


db.students.find({ gender: "male" });


db.students.find({ room_id: 110 });


db.students.find().sort({ admission_date: -1 });
