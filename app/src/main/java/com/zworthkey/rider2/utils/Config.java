package com.zworthkey.rider2.utils;

public class Config {
     private static String token="";

     private    final String BaseUrl="http://ecd9d882948e.ngrok.io";
     private    final String CONSUMER_KEY="ck_b710c9e85fb790932daf38bbdac879d3b812f265";
     private    final String CONSUMER_SECRET="cs_5cbe57eec729324c48e8f3588d69277aac37fcc0";
     private static String riderUsername="";
     private static String riderUserPassword="";


     public     String getBaseUrl() {
        return BaseUrl;
    }

     public     String getToken() {
         return token;
     }

     public Config( String token)
     {

         this.token = token;
     }
     public Config(){}

     public   String getConsumerKey()
     {
         return CONSUMER_KEY;
     }
    public   String getConsumerSecret()
    {
        return CONSUMER_SECRET;
    }

    public String getRiderUsername() {
        return this.riderUsername;
    }

    public String getRiderUserPassword() {
        return this.riderUserPassword;
    }

    public void setRiderUsername(String riderUsername) {
        this.riderUsername = riderUsername;
    }


    public void setRiderUserPassword(String riderUserPassword) {
        this.riderUserPassword = riderUserPassword;
    }
}
