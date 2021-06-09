package com.zworthkey.rider2.utils.pojoClasses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoUserResponse {

    @SerializedName("data")
    @Expose
    private PojoUserData data;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("caps")
    @Expose
    private Caps caps;
    @SerializedName("cap_key")
    @Expose
    private String capKey;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;

    @SerializedName("allcaps")
    @Expose
    private Allcaps allcaps;
    @SerializedName("filter")
    @Expose
    private Object filter;
    private String loginStatus;
    private String error;

    public PojoUserData getUserData() {
        return data;
    }

    public void setUserData(PojoUserData data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Caps getCaps() {
        return caps;
    }

    public void setCaps(Caps caps) {
        this.caps = caps;
    }

    public String getCapKey() {
        return capKey;
    }

    public void setCapKey(String capKey) {
        this.capKey = capKey;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Allcaps getAllcaps() {
        return allcaps;
    }

    public void setAllcaps(Allcaps allcaps) {
        this.allcaps = allcaps;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PojoUserResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("caps");
        sb.append('=');
        sb.append(((this.caps == null)?"<null>":this.caps));
        sb.append(',');
        sb.append("capKey");
        sb.append('=');
        sb.append(((this.capKey == null)?"<null>":this.capKey));
        sb.append(',');
        sb.append("roles");
        sb.append('=');
        sb.append(((this.roles == null)?"<null>":this.roles));
        sb.append(',');
        sb.append("allcaps");
        sb.append('=');
        sb.append(((this.allcaps == null)?"<null>":this.allcaps));
        sb.append(',');
        sb.append("filter");
        sb.append('=');
        sb.append(((this.filter == null)?"<null>":this.filter));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


    public String getErrorMessage() {
        return this.error;
    }
}
