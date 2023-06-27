# JDBC Template

- Spring provides a helper class that simplifies our JDBC applications
- takes care of all the boilerplate code
  - getting a connection
  - create prepared statement object
  - set the parameters for the prepared statement (if any)
  - execute the query
  - get the result of the query
  - handle exceptions
  - close all resources
- We have to facilitate spring with:
  - SQL command
  - values for the parameters
  - logic for handling the result of the query execution
- Very useful if you are migrating from a JDBC application to a Spring application
