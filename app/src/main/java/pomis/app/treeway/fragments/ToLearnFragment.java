package pomis.app.treeway.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pomis.app.treeway.R;
import pomis.app.treeway.adapters.SkillAdapter;
import pomis.app.treeway.models.ProfileModel;
import pomis.app.treeway.models.SkillModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToLearnFragment extends Fragment {



    ListView lvSkills;
    ArrayList<SkillModel> skills;
    SkillAdapter adapter;

    public ToLearnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_to_learn, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        initArray();
        initList();
    }

    private void initArray() {
        skills = new ArrayList<>();
        ProfileModel verstka = new ProfileModel("Вёрстка");
        ProfileModel oop = new ProfileModel("ООП");
        ProfileModel fun = new ProfileModel("Функциональное программирование");
        ArrayList<ProfileModel> cssProfiles = new ArrayList<>();
        cssProfiles.add(verstka);
        ArrayList<ProfileModel> vars = new ArrayList<>();
        vars.add(fun);
        vars.add(oop);
        SkillModel cssSkill = new SkillModel("CSS-селекторы", cssProfiles);
        SkillModel varSkill = new SkillModel("Переменные", vars);
        skills.add(cssSkill);
        skills.add(varSkill);
    }

    private void initList() {
        lvSkills = (ListView) getActivity().findViewById(R.id.lv_skills);
        adapter = new SkillAdapter(getContext(), 0, skills);
        lvSkills.setAdapter(adapter);
    }

}
