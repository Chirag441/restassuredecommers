package utils;

import StepDefination.Resource;

public class BaseConext {
     public  ObjecFiles objecFiles;
    public RequestParentClass requestParentClass;
    public Resource resource;



    public  void setup()
    {

        objecFiles = new ObjecFiles();
        requestParentClass = new RequestParentClass();
        resource = new Resource();
        resource.setObjecFiles(objecFiles);
        resource.setup();
        requestParentClass.setObjecFiles(objecFiles);
        requestParentClass.setup();

    }
}
