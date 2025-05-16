# GEOSPATIALINDEXING
 Aim:
 To implement geospatial indexing on embedded documents in mongodb.
 Procedure:/
 1. Start
 2. Start mongoshell using client.
 3. Create database and collection.
 4. Perform geospatial indexes operation on embedded documents.
 5. Print the output.
 6. Stop.

###  GeospatialData
db.places.insertMany( [
  {
      name: "Central Park",
      location: { type: "Point", coordinates: [ -73.97, 40.77 ] },
      category: "Parks"
  },
  {
      name: "Sara D. Roosevelt Park",
      location: { type: "Point", coordinates: [ -73.9928, 40.7193 ] },
      category: "Parks"
  },
  {
      name: "Polo Grounds",
      location: { type: "Point", coordinates: [ -73.9375, 40.8303 ] },
      category: "Stadiums"
  }
] )
###  CreateGeospatial Index:
db.places.createIndex ({location:"2dsphere"})
### near
db.places.find({location:{$near:{$geometry:{type:"Point",coordinates:[-73.9667,40.78]},$minDistance:1000,$maxDistance:5000}}})
### $geoNear
db.places.aggregate( [ { $geoNear: { near: { type: "Point", coordinates: [-73.9667,40.78 ] }, spherical: true, query: { category: "Parks" },distanceField: "calcDistance"} }])
### geowithin
db.places.find({loc:{$geoWithin:{$geometry:{type:"Polygon",coordinates:[[[0,0],[3,6],[6,1],[0,0]]]}}}});
### geointersects
db.places.find({loc:{$geoIntersects:{$geometry:{type:"Polygon",coordinates:[[[0,0],[3,6],[6,1],[0,0] ]]}}}})