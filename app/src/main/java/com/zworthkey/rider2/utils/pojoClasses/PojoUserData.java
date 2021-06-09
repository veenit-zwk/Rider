



package com.zworthkey.rider2.utils.pojoClasses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

 class Allcaps {

    @SerializedName("read")
    @Expose
    private Boolean read;
    @SerializedName("level_0")
    @Expose
    private Boolean level0;
    @SerializedName("subscriber")
    @Expose
    private Boolean subscriber;

    public Boolean getRead() {
        return read;
    }



    public Boolean getLevel0() {
        return level0;
    }

    public void setLevel0(Boolean level0) {
        this.level0 = level0;
    }

    public Boolean getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Boolean subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Allcaps.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("read");
        sb.append('=');
        sb.append(((this.read == null)?"<null>":this.read));
        sb.append(',');
        sb.append("level0");
        sb.append('=');
        sb.append(((this.level0 == null)?"<null>":this.level0));
        sb.append(',');
        sb.append("subscriber");
        sb.append('=');
        sb.append(((this.subscriber == null)?"<null>":this.subscriber));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}


 class Caps {

    @SerializedName("subscriber")
    @Expose
    private Boolean subscriber;

    public Boolean getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Boolean subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Caps.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subscriber");
        sb.append('=');
        sb.append(((this.subscriber == null)?"<null>":this.subscriber));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}


public class PojoUserData {

    @SerializedName("ID")
    @Expose
    private String id;
    @SerializedName("user_login")
    @Expose
    private String userLogin;
    @SerializedName("user_pass")
    @Expose
    private String userPass;
    @SerializedName("user_nicename")
    @Expose
    private String userNicename;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_url")
    @Expose
    private String userUrl;
    @SerializedName("user_registered")
    @Expose
    private String userRegistered;
    @SerializedName("user_activation_key")
    @Expose
    private String userActivationKey;
    @SerializedName("user_status")
    @Expose
    private String userStatus;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    private String loginStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(String userRegistered) {
        this.userRegistered = userRegistered;
    }

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLoginStatus() {
        return this.loginStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PojoUserData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("userLogin");
        sb.append('=');
        sb.append(((this.userLogin == null)?"<null>":this.userLogin));
        sb.append(',');
        sb.append("userPass");
        sb.append('=');
        sb.append(((this.userPass == null)?"<null>":this.userPass));
        sb.append(',');
        sb.append("userNicename");
        sb.append('=');
        sb.append(((this.userNicename == null)?"<null>":this.userNicename));
        sb.append(',');
        sb.append("userEmail");
        sb.append('=');
        sb.append(((this.userEmail == null)?"<null>":this.userEmail));
        sb.append(',');
        sb.append("userUrl");
        sb.append('=');
        sb.append(((this.userUrl == null)?"<null>":this.userUrl));
        sb.append(',');
        sb.append("userRegistered");
        sb.append('=');
        sb.append(((this.userRegistered == null)?"<null>":this.userRegistered));
        sb.append(',');
        sb.append("userActivationKey");
        sb.append('=');
        sb.append(((this.userActivationKey == null)?"<null>":this.userActivationKey));
        sb.append(',');
        sb.append("userStatus");
        sb.append('=');
        sb.append(((this.userStatus == null)?"<null>":this.userStatus));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("login_status: "+this.loginStatus);
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
