package esmeralda.projects.JIntegrator.business;

import java.io.File;
import java.io.FilenameFilter;

public final class ExtFilterFiles implements FilenameFilter
{

private String ext;

public ExtFilterFiles(String ext) {

    this.ext=ext.toLowerCase();

}


    @Override
    public boolean accept(File dir, String name) {
        return(name.toLowerCase().endsWith(this.ext));
    }
}
