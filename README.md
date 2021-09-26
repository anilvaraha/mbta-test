# mbta-test
Note : make sure Maven is installed
<br/>Step 1:  git clone https://github.com/anilvaraha/mbta-test.git cd {local desktop path}

<br/>Step 2: goto above folder and open Command prompt.

<br/>Step 3 : run command : mvn spring-boot:run

<br/>Step 4 : For question 1 : access url : http://localhost:8080/commuter/routes/longnames

<br/>Step 5 : for question 2 : access url : http://localhost:8080/commuter/routes/stops?routeName=Framingham/Worcester%20Line
  
      <br/>Step 5.1: routeName can be changed to the values from the step4 to see the Stops in that route line

<br/>Step 6 : for Question 3 : access url : http://localhost:8080/commuter/routes/name?from=Ashland&to=Boston%20Landing  
  
      <br/>Step 6.1 :From and to values can be changed and fix if there is Route line that can help out.
