package sg.edu.nus.iss.ssf_workshop16.model;

import java.io.Serializable;

import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Rulebook implements Serializable{
    
    private int total_count;
    private String file;
    public int getTotal_count() {
        return total_count;
    }
    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }

    public JsonObjectBuilder toJSON(){
        return Json.createObjectBuilder()
                .add("type",this.getTotal_count())
                .add("count",this.getTotal_count());
    }
    
    public static Rulebook createJson(JsonObject o){
        Rulebook r  = new Rulebook();
        JsonNumber totalCount = o.getJsonNumber("total_count");
        r.setTotal_count(totalCount.intValue());
        r.setType(o.getString("total_count"));
        return r;
    }
    

}
