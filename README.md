# Demo_Project

Easy steps to start :

1) Clone repository :

  git clone https://github.com/ezaichuk/Demo_Project.git

2) Create your own branch :

  git checkout -b &lt;your_branch_name&gt;

    example : git checkout -b asinuk

3) Open project in Intellij Idea

4) Click View-&gt; Tool windows -&gt; Maven Projects

  You'll see settings of run.

  Example : 

    Profiles -&gt; chrome, grid_local and testhost checked

    DP1 -&gt; Lifecycle -&gt; choose "test" and click Green Arrow under Maven Projects window

    

    It will run tests on Chrome browser using Selenium grid on your own host.

    

5) Which tests will be executed ?

Locate file /src/test/resources/testng.xml

&lt;?xml version="1.0" encoding="UTF-8"?&gt;

&lt;!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" &gt;

&lt;suite name="Tests" verbose="5"&gt;

  &lt;test name="Test1"&gt;                 &lt;!-- THIS IS TEST NAME, CREATE YOUR OWN--&gt;

    &lt;classes&gt;                          &lt;!-- HERE ARE LIST OF TEST CLASSES THAT WILL BE EXECUTED --&gt;

      &lt;class name="test.exampleTest"/&gt;  

    &lt;/classes&gt;

  &lt;/test&gt;  

&lt;/suite&gt;
