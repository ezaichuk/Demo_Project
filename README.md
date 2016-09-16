# Demo_Project

Easy steps to start :

1) Clone repository :
  git clone https://github.com/ezaichuk/Demo_Project.git
2) Create your own branch :
  git checkout -b <your_branch_name>
    example : git checkout -b asinuk
3) Open project in Intellij Idea
4) Click View-> Tool windows -> Maven Projects
  You'll see settings of run.
  Example : 
    Profiles -> chrome, grid_local and testhost checked
    DP1 -> Lifecycle -> choose "test" and click Green Arrow under Maven Projects window
    
    It will run tests on Chrome browser using Selenium grid on your own host.
    
5) Which tests will be executed ?

Locate file /src/test/resources/testng.xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Tests" verbose="5">
  <test name="Test1">                 <!-- THIS IS TEST NAME, CREATE YOUR OWN-->
    <classes>                          <!-- HERE ARE LIST OF TEST CLASSES THAT WILL BE EXECUTED -->
      <class name="test.exampleTest"/>  
    </classes>
  </test>  
</suite>
