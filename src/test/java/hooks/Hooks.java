package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;
import utilities.ReusableMethods;

import static base_urls.ContactListAppBaseUrl.setUp;

public class Hooks {


    @Before("@api")
    public void beforeApi(){
        setUp();
    }

    //@After
    //public void after(Scenario scenario) {
    //    if (scenario.isFailed()) {
    //        ReusableMethods.allPageScreenShot();
    //        Driver.closeDriver();
    //    }

    //}

}
