package esmeralda.projects.JIntegrator.business;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;


public final class IntegratorClassLoader extends URLClassLoader {




    ////////////////
    //Constructor//
    //////////////

    public IntegratorClassLoader(ClassLoader parent) {//constructor

       this(new URL[0],parent);

       URL urls[];

       if ((parent instanceof IntegratorClassLoader) ||(parent instanceof URLClassLoader)) {

           urls=((URLClassLoader)parent).getURLs();
            for (int i=0;i<urls.length;i++) {

                super.addURL(urls[i]);

            }

       }


    }//constructor



    public IntegratorClassLoader(URL[] urls) {//constructor

        super(urls);



    }//constructor


    public IntegratorClassLoader(URL[] urls, ClassLoader parent) {//constructor

        super(urls,parent);



    }//constructor


    public IntegratorClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {//constructor

        super(urls,parent,factory);



    }//constructor

    ////////////
    //Métodos//
    //////////

    public void addURL(URL url) {//addURL

        super.addURL(url);

    }//addURL




}
