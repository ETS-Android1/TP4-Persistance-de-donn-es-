package com.enset.tp4_persistance_de_donnes.metier;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.enset.tp4_persistance_de_donnes.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class EtudiantAdapter extends ArrayAdapter<Etudiant>
{

    private  int resource;
    private Context contextFrag;
    public EtudiantAdapter(@NonNull Context context, int resource, List<Etudiant> etudiants)
    {
        super(context, resource, etudiants);
        this.resource = resource;
        contextFrag = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //setup Image Loader
        setupImageLoader();
        View listViewItem = convertView;
        if(listViewItem==null)
        {
            listViewItem = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        TextView cineEtudiant = listViewItem.findViewById(R.id.cineEtudiant);
        TextView nomEtudiant = listViewItem.findViewById(R.id.nomEtudiant);
        TextView prenomEtudiant = listViewItem.findViewById(R.id.prenomEtudiant);
        TextView neLeEtudiant = listViewItem.findViewById(R.id.neLeEtudiant);
        TextView niveauEtudiant = listViewItem.findViewById(R.id.niveauEtudiant);
        ImageView imageEtudiant = listViewItem.findViewById(R.id.imageEtudiant);

        cineEtudiant.setText(getItem(position).getCine());
        nomEtudiant.setText(getItem(position).getNom());
        prenomEtudiant.setText(getItem(position).getPrenom());
        neLeEtudiant.setText(getItem(position).getDateNaissance());
        niveauEtudiant.setText(getItem(position).getNiveau());

        String imageURL = getItem(position).getPhoto();

        int defaultImage = contextFrag.getResources().getIdentifier("@drawable/defaultt", null, contextFrag.getOpPackageName());

        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

         //download and display image from url
        imageLoader.displayImage(imageURL, imageEtudiant, options);

        Log.i("info", "===============>  "+imageEtudiant.toString());
        return listViewItem;
    }

    private void setupImageLoader()
    {
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                contextFrag)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
