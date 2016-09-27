# Demo Test Project

### Easy steps to start :
* Clone repository :
```sh
 $ git clone https://github.com/ezaichuk/Demo_Project.git
```
* Create your own branch and switch to it:
```sh
$ git checkout -b <your_branch_name>
```
* Open project in Intellij Idea
* Click View-&gt; Tool windows -&gt; Maven Projects

> Select browser and environment in profiles. 
> Then choose "test" and click Green Arrow under Maven Projects window.
> It will run tests on Firefox browser using Selenium grid on your own host.

![MVN profiles](https://cldup.com/XdSHdd1IsT.png)


* Which tests will be executed ?

> Open  /src/test/resources/testng.xml and edit classes section

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Tests" verbose="5">
  <test name="Main Page tests">      <!-- THIS IS TEST NAME, CREATE YOUR OWN-->
    <classes>                        <!-- HERE ARE LIST OF TEST CLASSES THAT WILL BE EXECUTED -->
      <class name="test.MainPage.LoginAsViewerAndLogout"/>
    </classes>
  </test>  
</suite>
```