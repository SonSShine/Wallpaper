
package com.example.assigment_sonvqph24812_androidnetworking.model.gallery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("galleries")
    @Expose
    private Galleries galleries;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Galleries getGalleries() {
        return galleries;
    }

    public void setGalleries(Galleries galleries) {
        this.galleries = galleries;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
