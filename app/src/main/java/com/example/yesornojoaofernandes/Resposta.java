package com.example.yesornojoaofernandes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resposta {
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("force")
    @Expose
    private boolean force;
    @SerializedName("image")
    @Expose
    private String image;

    public Resposta(String answer, boolean force, String image) {
        this.answer = answer;
        this.force = force;
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
