# Rest-Service
Rest Service Java \
This is a simple rest service in java \
The user can create offers(description , price ,expirydate) and if an offer has expired it is returned with a boolean flag true.\
A thread runs every 30 seconds to ckeck if the offer has expired.\
All the offers are stored in memory.\
The user can make the below http requests\
@POST : you can post an offer object to the server\
@GET : you can get all the existing offers\
@GET : you can get a specific offer by passing the offer description\
@DELETE : you can delete a specific offer by passing the offer description\
When you deploy the app you can access it at the following URL: https://localhost:8080/webapi/myresource
