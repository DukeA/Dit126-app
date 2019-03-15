# Dit126-app

## Group members
<table style="width:100%">
    <tr>
      <th>Name</th>
      <th>GitHub</th> 
    </tr>
    <tr>
      <td> Adam Grandén </td>
      <td> DukeA </td>
    </tr>
    <tr>
      <td> Gustav Albertsson </td>
      <td> galbertsson </td>
    </tr>
    <tr>
      <td> Robin Hekmatara </td>
      <td> robinhekmatara </td>
    </tr>
    <tr>
      <td> Johan Svennungsson  </td>
      <td> knya </td>
    </tr>
</table>

## Requirements
This application requires PostgreSQL to be installed and running on `localhost:5432`
This database has to have a schema called `dit126` and a user `admin` and password `3wYTiwSN112M` has to have access to it. 

To setup the database the contents of `webapp/src/main/DatabaseCode/databaseSql.sql` has to be ran in order to create the correct tables and setup some sample data.

## Running the project
The project is a maven project so maven needs to be installed in order to run the project. 

## Repo structure
In the webapp directory the code and tests could be found:
* In the directory `webapp/src/main/` the code for the application could be found
* In the directory `webapp/src/test/java/dit126/` the test code could be found

In the Report direcrory the report and report figures can be found
