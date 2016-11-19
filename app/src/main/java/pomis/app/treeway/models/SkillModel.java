package pomis.app.treeway.models;

import java.util.ArrayList;

/**
 * Created by romanismagilov on 19.11.16.
 */

public class SkillModel {
    public String name;
    public ArrayList<ProfileModel> profiles;

    public SkillModel(String name, ArrayList<ProfileModel> profiles) {
        this.name = name;
        this.profiles = profiles;
    }

    public String getProfiles() {
        String buffer = "";
        for (ProfileModel profile : profiles) {
            buffer += profile.name;
            buffer += ", ";
        }
        buffer = buffer.substring(0, buffer.length()-2);
        return buffer;
    }
}
