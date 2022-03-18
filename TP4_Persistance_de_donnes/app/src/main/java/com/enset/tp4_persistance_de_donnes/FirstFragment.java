package com.enset.tp4_persistance_de_donnes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.enset.tp4_persistance_de_donnes.databinding.FragmentFirstBinding;
import com.enset.tp4_persistance_de_donnes.metier.Etudiant;
import com.enset.tp4_persistance_de_donnes.metier.EtudiantAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView cineEtudiant;
    TextView nomEtudiant;
    TextView prenomEtudiant;
    TextView neLeEtudiant;
    TextView niveauEtudiant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Etudiant etudiant = null;
       /* SharedPreferences sh  = getActivity().getSharedPreferences("tpsharedPreference", Context.MODE_PRIVATE);

        etudiant.setCine(sh.getString("cine",""));
        etudiant.setNom(sh.getString("nom",""));
        etudiant.setPrenom(sh.getString("prenom",""));
        etudiant.setDateNaissance(sh.getString("nele",""));
        etudiant.setNiveau(sh.getString("niveau",""));*/

        ;
        List<Etudiant> data = new ArrayList<>();
        try
        {
            FileInputStream fis = getActivity().openFileInput("etudiants.dat");
            BufferedInputStream bfs = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(fis);

            data.addAll((List<Etudiant>)ois.readObject());
            ois.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        EtudiantAdapter etudiantAdapter = new EtudiantAdapter(getActivity(),R.layout.list_item_fragement_first, data);
        binding.listEtudiant.setAdapter(etudiantAdapter);
        etudiantAdapter.notifyDataSetChanged();

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}