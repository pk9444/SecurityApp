
# SecurityApp
Implementing Security Tactics using JAAS - Java Authentication and Authorization Services

## Running the project 
- Download the project or ```git clone``` the repository
- Open with IntelliJ or Eclisipe or any other Java IDE
- retrieve the defined username, password and AuthorizedActions.java and test the app 

## Framework 
JAAS - Java Authentication and Authorization services - a Java framework providing the functionalities to authenticate users in a system through defined credentials (username and password) and enabling access. Provides Authorization by implementing the PrivilegedActions Interface and defined the authrorized action according to authenticated user's credentials 

## Functionalities 
- LoginModule - define a methods that enable a login action 
- CallbackHandler - handle callbacks every time a particular user logs in or logs out
- Principal - define the current logged in user's actions - any method signature for a current logged-in user is defined by a principle's object
- PrivilegedActions - Interface providing the functionality for defining what action a certain logged-in user can perform 
- JAAS.config - the configuration file that sets the LoginModule functionality to true and enables the JAAS framework 

