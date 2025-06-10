package StepDefination;

import io.cucumber.java.Before;
//import utils.BaseConext;
import utils.BaseConext;
import utils.Request;

public class Hooks
{

BaseConext base;
public  Hooks(BaseConext base)
{
    this.base = base;
}

@Before
    public  void basesetup()

{
   base.setup();
}

}
