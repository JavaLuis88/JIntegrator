package PruebaPreloaders;

import esmeralda.projects.JIntegrator.exceptions.PreLoadException;
import esmeralda.projects.JIntegrator.apps.PreLoader;

import java.util.Map;

public class CustomPreloader implements  PreLoader{


    @Override
    public void initintegrator(Map<String, Object> bang) throws PreLoadException {

        System.out.println("ENTRA EN INITINTEGRATOR");
        bang.put("TCL","Tk");

    }
}
