package Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FootballClubContainer {
    private ArrayList<FootballClub> clubs;
    private String name;

    // setFromJsonObject sets the model with the given JSONObject (the json object should be the root object)
    public void setFromJsonObject (JSONObject jsonObject) {
        // if null immediately return
        if (jsonObject == null) {
            return;
        }

        // set the FootballClubContainer name from the root jsonObject
        this.name = jsonObject.getString("name");

        // get JsonArray inside JsonObject
        JSONArray jsonArray = jsonObject.getJSONArray("clubs");


        if (this.clubs == null) {
            this.clubs = new ArrayList<FootballClub>();
        } else { // remove all clubs if not null
            this.clubs.removeAll(this.clubs);
        }

        for (int i = 0; i < jsonArray.length() ; i++) {
            JSONObject clubJsonObject = jsonArray.getJSONObject(i);

            FootballClub clubModel = new FootballClub();
            clubModel.setName(clubJsonObject.getString("name"));
            try {
                clubModel.setCode(clubJsonObject.getString("code"));
            } catch (JSONException e){
                clubModel.setCode(null);
            }
            clubModel.setCountry(clubJsonObject.getString("country"));

            this.clubs.add(i, clubModel);
        }
    }

    public void printWithDescription () {
        System.out.println("Football club name: " + this.name);

        System.out.println("\tFootball club members:");

        for (FootballClub club:this.clubs) {
            System.out.println("\t\tName: " + club.getName());
            System.out.println("\t\t\tCode: " + club.getCode());
            System.out.println("\t\t\tCountry: " + club.getCountry());
        }
    }

    public ArrayList<FootballClub> getClubs() {
        return clubs;
    }

    // Get clubs by the given name
    public ArrayList<FootballClub> getClubsByName (String name) {
        ArrayList<FootballClub> filteredClubs = this.clubs
                .stream()
                .filter(club -> club.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
        return filteredClubs;
    }

    public void setClubs(ArrayList<FootballClub> clubs) {
        this.clubs = clubs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
