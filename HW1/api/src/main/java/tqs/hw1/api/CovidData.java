package tqs.hw1.api;

import java.util.Objects;


public class CovidData {
    private String country = "";
    private String region_name = "";
    private String city_name = "";
    private String date = "";

    public CovidData(String country, String region_name, String city_name, String date) {
        this.country = country;
        this.region_name = region_name;
        this.city_name = city_name;
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CovidData() {
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion_name() {
        return this.region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCity_name() {
        return this.city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public CovidData country(String country) {
        setCountry(country);
        return this;
    }

    public CovidData region_name(String region_name) {
        setRegion_name(region_name);
        return this;
    }

    public CovidData city_name(String city_name) {
        setCity_name(city_name);
        return this;
    }




    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CovidData)) {
            return false;
        }
        CovidData covidData = (CovidData) o;
        return Objects.equals(country, covidData.country) && Objects.equals(region_name, covidData.region_name) && Objects.equals(city_name, covidData.city_name) && Objects.equals(date, covidData.date);
    }

    @Override
    public String toString() {
        return "{" +
            " country='" + getCountry() + "'" +
            ", region_name='" + getRegion_name() + "'" +
            ", city_name='" + getCity_name() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region_name, city_name);
    }

}
