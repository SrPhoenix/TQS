package tqs.hw1.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Region {
    private String iso;
    private String province;
    private List<City> cities;
    private String name;
    private String lat;
    @SerializedName("long")
    private String _long;






    public Region() {
    }


    public String getIso() {
        return this.iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<City> getCities() {
        return this.cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Region iso(String iso) {
        setIso(iso);
        return this;
    }

    public Region province(String province) {
        setProvince(province);
        return this;
    }

    public Region cities(List<City> cities) {
        setCities(cities);
        return this;
    }

    public Region name(String name) {
        setName(name);
        return this;
    }

    public Region lat(String lat) {
        setLat(lat);
        return this;
    }

    public Region lon(String lon) {
        setLong(lon);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " iso='" + getIso() + "'" +
            ", province='" + getProvince() + "'" +
            ", cities='" + getCities() + "'" +
            ", name='" + getName() + "'" +
            ", lat='" + getLat() + "'" +
            ", long='" + getLong() + "'" +
            "}";
    }

}
