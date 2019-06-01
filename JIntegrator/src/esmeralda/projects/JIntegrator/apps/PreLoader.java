package esmeralda.projects.JIntegrator.apps;

import esmeralda.projects.JIntegrator.exceptions.PreLoadException;

import java.util.Map;

public interface PreLoader {//interface


    public void initintegrator(Map<String, Object> bang) throws PreLoadException;


}//interface
