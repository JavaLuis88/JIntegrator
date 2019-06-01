package esmeralda.libs.SystemTools;

public final class SystemInfo {//class



    private String os;
    private String osarch;
    private String osversion;
    private String jvmname;
    private String jvmversion;
    private String jvmvendor;




    ///////////////
    //Contructor//
    /////////////



    public SystemInfo() {//constructor



        this.os= System.getProperty("os.name");
        this.osarch= System.getProperty("os.arch");
        this.osversion= System.getProperty("os.version");
        this.jvmname=System.getProperty("java.vm.name");
        this.jvmversion=System.getProperty("java.vm.version");
        this.jvmvendor=System.getProperty("java.vm.vendor");


    }//constructor

    ////////////
    //Mŕtodos//
    //////////


    public String getOs() {//getOs

        return os;

    }//getOs

    public String getOsarch() {//getOsarch

        return osarch;

    }//getOsarch

    public String getOsversion() {//getOsversion

        return osversion;

    }//getOsversion

    public String getJvmname() {//getJvmname

        return jvmname;

    }//getJvmname

    public String getJvmversion() {//getJvmversion

        return jvmversion;

    }//getJvmversion

    public String getJvmvendor() {//getJvmvendor

        return jvmvendor;

    }//getJvmvendor


    public boolean isWindows() {//isWindows

        return (this.os.toLowerCase().indexOf("win") >= 0);

    }//isWindows



    public  boolean isMac() {//isMac

        return (this.os.toLowerCase().indexOf("mac") >= 0);

    }//isMac



    public boolean isUnix() {//isUnix

        return (this.os.toLowerCase().indexOf("nix") >= 0 || this.os.toLowerCase().indexOf("nux") >= 0 || this.os.toLowerCase().indexOf("aix") > 0 );

    }//isUnix



    public boolean isSolaris() {//isSolaris

        return (this.os.toLowerCase().indexOf("sunos") >= 0);

    }//isSolaris

    public boolean isAndroid() {//isAndroid

        return (this.jvmvendor.toLowerCase().indexOf("android")>=0);

    }//isAndroid

}//class
