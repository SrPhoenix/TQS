package tqs.hw1.api.model;

import com.google.gson.annotations.SerializedName;

public class City {
    private String name;
    private String date;
    private long fips;
    private String lat;
    @SerializedName("long")
    private String _long;
    private Long confirmed;
    private int deaths;
    private int confirmed_diff;
    private int deaths_diff;
    private String last_update;
    

    public City() {
    }
    public String getCityName() {
        return this.name;
    }
   
    public void setCityName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getFips() {
        return this.fips;
    }

    public void setFips(long fips) {
        this.fips = fips;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return this._long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public Long getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Long confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return this.deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getConfirmed_diff() {
        return this.confirmed_diff;
    }

    public void setConfirmed_diff(int confirmed_diff) {
        this.confirmed_diff = confirmed_diff;
    }

    public int getDeaths_diff() {
        return this.deaths_diff;
    }

    public void setDeaths_diff(int deaths_diff) {
        this.deaths_diff = deaths_diff;
    }

    public String getLast_update() {
        return this.last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public City CityName(String name) {
        setCityName(name);
        return this;
    }

    public City date(String date) {
        setDate(date);
        return this;
    }

    public City fips(long fips) {
        setFips(fips);
        return this;
    }

    public City lat(String lat) {
        setLat(lat);
        return this;
    }

    public City lon(String lon) {
        setLong(lon);
        return this;
    }

    public City confirmed(Long confirmed) {
        setConfirmed(confirmed);
        return this;
    }

    public City deaths(int deaths) {
        setDeaths(deaths);
        return this;
    }

    public City confirmed_diff(int confirmed_diff) {
        setConfirmed_diff(confirmed_diff);
        return this;
    }

    public City deaths_diff(int deaths_diff) {
        setDeaths_diff(deaths_diff);
        return this;
    }

    public City last_update(String last_update) {
        setLast_update(last_update);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getCityName() + "'" +
            ", date='" + getDate() + "'" +
            ", fips='" + getFips() + "'" +
            ", lat='" + getLat() + "'" +
            ", long='" + getLong() + "'" +
            ", confirmed='" + getConfirmed() + "'" +
            ", deaths='" + getDeaths() + "'" +
            ", confirmed_diff='" + getConfirmed_diff() + "'" +
            ", deaths_diff='" + getDeaths_diff() + "'" +
            ", last_update='" + getLast_update() + "'" +
            "}";
    }


}