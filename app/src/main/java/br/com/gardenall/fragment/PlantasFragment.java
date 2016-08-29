package br.com.gardenall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.gardenall.R;
import br.com.gardenall.adapter.PlantasAdapter;
import br.com.gardenall.domain.Planta;
import br.com.gardenall.domain.PlantaService;

/**
 * Created by diego on 26/08/16.
 */
public class PlantasFragment extends Fragment {
    protected RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private List<Planta> plantas;
    private String tabIdentifier;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            this.tabIdentifier = getArguments().getString("tab");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskPlantas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plantas, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Linear Layout Manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    private void taskPlantas(){
        // Busca as plantas
        this.plantas = PlantaService.getPlantas(getContext());
        // Atualiza a lista
        mRecyclerView.setAdapter(new PlantasAdapter(getContext(), plantas, onClickPlanta()));
    }

    private PlantasAdapter.PlantaOnClickListener onClickPlanta(){
        return new PlantasAdapter.PlantaOnClickListener(){
            @Override
            public void onClickPlanta(View view, int idx){
                Planta planta = plantas.get(idx);
                Toast.makeText(getContext(), planta.getNomePlanta(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}
