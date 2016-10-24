package br.com.gardenall.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by diego on 26/08/16.
 */
public class Planta implements Parcelable {
    private int favorito;
    private int selected;

    @SerializedName("id_p")
    private long id;
    @SerializedName("nome")
    private String nomePlanta;
    @SerializedName("url")
    private String urlImagem;

    public Planta(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomePlanta(){
        return nomePlanta;
    }

    public void setNomePlanta(String nomePlanta){
        this.nomePlanta = nomePlanta;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void invertSelected() {
        if(selected == 0)
            selected = 1;
        else
            selected = 0;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getFavorito() {
        return favorito;
    }

    // Parcelable
    public Planta(Parcel parcel){
        setId(parcel.readLong());
        setNomePlanta(parcel.readString());
        setUrlImagem(parcel.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(getNomePlanta());
        dest.writeString(getUrlImagem());
    }

    public static final Parcelable.Creator<Planta> CREATOR = new Parcelable.Creator<Planta>(){
        @Override
        public Planta createFromParcel(Parcel source){
            return new Planta(source);
        }

        @Override
        public Planta[] newArray(int size){
            return new Planta[size];
        }
    };
}