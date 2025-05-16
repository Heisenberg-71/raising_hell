# SHARDING
 Aim:
 To implement Sharding on embedded documents in mongodb.
 Procedure:
 1. Start
 2. Start mongoshell using client.
 3. Create database and collection.
 4. Perform sharding on embedded documents.
 5. Print the output.
 6. Stop.
 
###  Initiation
rs.initiate()
### CheckforStatus
rs.status()
###  Addshard
sh.addShard("ShardReplset/10.10.10.58:27018")
### Createsharddatabase:
sh.enableSharding("persons")