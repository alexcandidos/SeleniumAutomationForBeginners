This project is designed to help beginners in automation.

**Setup:**
* Before starting, please download the Chromedriver binary according to your OS:
1. Go to https://googlechromelabs.github.io/chrome-for-testing/ and download it
2. Unzip and add the binary to `src/main/resources/`

**How to run the tests?**
1. Go to `src/main/java/runner/RunTest.java`
2. Right-click with the mouse > then click on the option **Run `RunTest`**
3. The test execution will start

**How to define which tests should be executed?**

In this project we are integrating Selenium with Cucumber (https://cucumber.io/docs/cucumber/) by writing the specifications using the Gherkin (https://cucumber.io/docs/gherkin/). Please read this overview (https://cucumber.io/docs/guides/overview/) to connect the dots.   
1. Go to `src/test/resources/features` open one of the `.feature` files available (e.g.: `Login.feature`)
2. Notice that we have some `@annotations` like `@RegressionLogin` or `@Test1`, `@Test2` and so on... 
3. Now, go to `src/main/java/runner/RunTest.java`
4. Notice that we have a way to define what tests we would like through the tags defined in the `@CucumberOptions`, which is set to `tags = "@RegressionLogin"` and will run all the test scenarios described in the `Login.feature` file since this tag was placed at the top of the file. But it could be something like `tags = "@Test1 and @Test2"` running only the scenarios specified.