package br.com.gardenall.domain;

/**
 * Created by diego on 26/08/16.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Planta implements Parcelable {
    private String nomePlanta;
    private String urlImagem;

    public Planta(){}

    public String getNomePlanta(){
        return nomePlanta;
    }

    public void setNomePlanta(String nomePlanta){
        this.nomePlanta = nomePlanta;
    }

    public String getUrlImagem(){
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem){
        this.urlImagem = urlImagem;
    }

    // Parcelable
    public Planta(Parcel parcel){
        setNomePlanta(parcel.readString());
        setUrlImagem(parcel.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
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
