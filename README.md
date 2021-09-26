# mbta-test
Note : make sure Maven is installed
Step 1:  git clone https://github.com/anilvaraha/mbta-test.git cd {local desktop path}
Step 2: goto above folder and open Command prompt.
Step 3 : run command : mvn spring-boot:run
Step 4 : For question 1 : access url : http://localhost:8080/commuter/routes/longnames
Step 5 : for question 2 : access url : http://localhost:8080/commuter/routes/stops?routeName=Framingham/Worcester%20Line
  Step 5.1: routeName can be changed to the values from the step4 to see the Stops in that route line
Step 6 : for Question 3 : access url : http://localhost:8080/commuter/routes/name?from=Ashland&to=Boston%20Landing  
  Step 6.1 :From and to values can be changed and fix if there is Route line that can help out.
