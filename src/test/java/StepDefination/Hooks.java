package StepDefination;

import io.cucumber.java.Before;
//import utils.BaseConext;
import utils.BaseConext;
import utils.Request;

public class Hooks
{
////Request request;
//
//
BaseConext base;
public  Hooks(BaseConext base)
{
    this.base = base;
   // this.request = base.generic;
}

@Before
    public  void basesetup()
{

   base.setup();

}

}
