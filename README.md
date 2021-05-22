1. git clone the project from repo
    git clone https://github.com/shreyas6969/ecommerce.git

2. In the clone location, move to the directory and run. 
   mvn spring-boot:run

3. If you using postman, you could use the below json and end points to access them 

Create userProfile
URL : localhost:8080/user/profile/
Body: JSON

{
  "email": "shreyas.v@abc.com",
  "firstName": "Shreyas",
  "lastName": "v",
  "phoneNumber": "9741256999",
  "primaryAddress": "123 quen road bangalore",
  "userImageUrl": "/profileImage/shreyas.jpeg"
}


Get user profile
localhost:8080/user/profile/1

Update user profile
URL : localhost:8080/user/profile/1
{
  "email": "shreyas.v@abc.com",
  "firstName": "Shreyas",
  "lastName": "v",
  "phoneNumber": "9741256999",
  "primaryAddress": "123456 quen road bangalore",
  "userImageUrl": "/profileImage/shreyas.jpeg"
}

4. Swagger URL 
http://localhost:8080/swagger-ui.html

