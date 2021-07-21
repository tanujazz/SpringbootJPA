Welcome to OneToManyJpa Spring Boot Application

Here are the steps to run the application
1) Application has one SpringBootApplication class that have the main method as the entry point i.e. SpringBootDemoApplication
2) Application has two controller class to expose the http rest end point for the crud operation of User Entity and Phone Entity
   Here is the list of end points
	1) http://localhost:8082/user/create (Create/Add a User with the phone/phones)
	2) http://localhost:8082/users/all   (Fetching all the Users)
	3) http://localhost:8082/user/update/:id (Updating the user with new phone/phones)
	4) http://localhost:8082/user/details/:id (Fetch details of a User )
	5) http://localhost:8082/user/phone/delete/:id  (Deleting a phone from the user)
	6) http://localhost:8082/user/update/prefPhoneNumber/:id/:phoneNumber (Updating a User with the preferred phone number)
	7) http://localhost:8082/phone/details/:id (Getting the phone details from phone entity via phone id)
	8) http://localhost:8082/user/phone/details/:id (Getting a user's phones from phone entity via user id)
	9) http://localhost:8082/phone/all (Fetching the details of all phones)
	10)http://localhost:8082/user/delete/:id (Deleting the user)

3) The application has two JPA repo for the JPA CRUD operation i.e. PhoneRepository, UserRepository
4) The application has two Service classes for the backend logic i.e PhoneService, UserService
5) The application has two entities (POJO) for one to many relationship i.e. User, Phone.

6) The application is using the spring security and on the application startup you have to type in Username "User" and Password will be updated with
   every boot and you can find the password at the application startup in the console (Example :Using default security password: d6d6745f-ccde-421a-b53c-cc493f84d178)
7) The application is using h2 in memory database which will erase with every boot (Can be replaced with other DB)
8) The application is using spring boot dev tools for the startup with every change
9) The application is using spring boot starter logging for the logger and I have captured the basic info
10) The application is using DataJpaTest for testing the JPA calls in the unit test, I would like to have more tests in place(these are basic test and I can write more tests for the code coverage)

