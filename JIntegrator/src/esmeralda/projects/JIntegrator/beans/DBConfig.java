package esmeralda.projects.JIntegrator.beans;

import java.io.Serializable;

public final class DBConfig implements Serializable,Cloneable {


   private String databasename;
   private String databasedriver;
   private String databaseurl;
   private String databaseuser;
   private String databasepassword;
   private boolean setterslock;



   public DBConfig() {

      this.databasename=null;
      this.databasedriver=null;
      this.databaseurl=null;
      this.databaseuser=null;
      this.databasepassword=null;
      this.setterslock=false;


   }




   public DBConfig(String databasename,String databasedriver,String databaseurl,String databaseuser,String databasepassword) {

      this.databasename=new String(databasename);
      this.databasedriver=new String(databasedriver);
      this.databaseurl=new String(databaseurl);
      this.databaseuser=new String(databaseuser);
      this.databasepassword=new String(databasepassword);
      this.setterslock=false;

   }



   public DBConfig(String databasename,String databasedriver,String databaseurl,String databaseuser,String databasepassword,boolean setterslock) {

      this.databasename=new String(databasename);
      this.databasedriver=new String(databasedriver);
      this.databaseurl=new String(databaseurl);
      this.databaseuser=new String(databaseuser);
      this.databasepassword=new String(databasepassword);
      this.setterslock=setterslock;

   }





   public String getDatabasename() {
      return new String(databasename);
   }

   public void setDatabasename(String databasename) {
      if (this.setterslock==false) {
         this.databasename = new String(databasename);

      }
   }


   public String getDatabasedriver() {
      return new String(databasedriver);
   }

   public void setDatabasedriver(String databasedriver) {
      if (this.setterslock==false) {

         this.databasedriver = new String(databasedriver);
      }
   }

   public String getDatabaseurl() {
      return new String(databaseurl);
   }

   public void setDatabaseurl(String databaseurl) {
      if (this.setterslock==false) {

         this.databaseurl = new String(databaseurl);
      }
   }

   public String getDatabaseuser() {
      return new String(databaseuser);
   }

   public void setDatabaseuser(String databaseuser) {
      if (this.setterslock==false) {

         this.databaseuser = new String(databaseuser);
      }
   }

   public String getDatabasepassword() {
      return new String(databasepassword);
   }

   public void setDatabasepassword(String databasepassword) {
      if (this.setterslock==false) {

         this.databasepassword = new String(databasepassword);
      }
   }

   public Object clone() {

      Object obj;
      obj=null;


      try {
         obj=super.clone();
         ((DBConfig)obj).databasename=new String(this.databasename);
         ((DBConfig)obj).databasedriver=new String(this.databasedriver);
         ((DBConfig)obj).databaseurl=new String(this.databaseurl);
         ((DBConfig)obj).databaseuser=new String(this.databaseuser);
         ((DBConfig)obj).databasepassword=new String(this.databasepassword);
      }
      catch(CloneNotSupportedException e) {



      }

      return obj;
   }



}
