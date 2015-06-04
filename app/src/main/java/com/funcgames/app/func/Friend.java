package com.funcgames.app.func;

import org.json.JSONException;
import org.json.JSONObject;

public class Friend {

    private static final String JSON_ID = "id";
    private static final String JSON_NAME = "name";
    private static final String JSON_NUMBER = "number";

    private String name;
    private String number;
    private String id;

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, id.toString());
        json.put(JSON_NAME, name);
        json.put(JSON_NUMBER, id);
        return json;
    }

    public Friend(){

    }

    public Friend(JSONObject json) throws JSONException {
        id = json.getString(JSON_ID);
        number = json.getString(JSON_NUMBER);
        name = json.getString(JSON_NAME);
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
