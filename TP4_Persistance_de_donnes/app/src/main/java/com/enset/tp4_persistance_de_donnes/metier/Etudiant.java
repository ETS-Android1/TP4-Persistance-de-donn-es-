package com.enset.tp4_persistance_de_donnes.metier;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Etudiant implements Serializable
{
    private String cine;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String niveau;
    private String photo;

    public String getCine() {
        return cine;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getPhoto() {
        return photo;
    }

    public void setCine(String cine) {
        this.cine = cine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
