package tqs.hw1.api.model;

public class ResponseData {
    private String date;
    private int confirmed_diff;
    private int active_diff;
    private int deaths_diff;
    private int recovered;
    private int recovered_diff;
    private double fatality_rate;
    private String last_update;
    private long active;
    private String iso;
    private String province;
    private String[] cities;
    private String name;
    private String lat;
    private String lon;
    private String confirmed;
    private String deaths;


    public ResponseData() {
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getConfirmed_diff() {
        return this.confirmed_diff;
    }

    public void setConfirmed_diff(int confirmed_diff) {
        this.confirmed_diff = confirmed_diff;
    }

    public int getActive_diff() {
        return this.active_diff;
    }

    public void setActive_diff(int active_diff) {
        this.active_diff = active_diff;
    }

    public int getDeaths_diff() {
        return this.deaths_diff;
    }

    public void setDeaths_diff(int deaths_diff) {
        this.deaths_diff = deaths_diff;
    }

    public int getRecovered() {
        return this.recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getRecovered_diff() {
        return this.recovered_diff;
    }

    public void setRecovered_diff(int recovered_diff) {
        this.recovered_diff = recovered_diff;
    }

    public double getFatality_rate() {
        return this.fatality_rate;
    }

    public void setFatality_rate(double fatality_rate) {
        this.fatality_rate = fatality_rate;
    }

    public String getLast_update() {
        return this.last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public long getActive() {
        return this.active;
    }

    public void setActive(long active) {
        this.active = active;
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

    public String[] getCities() {
        return this.cities;
    }

    public void setCities(String[] cities) {
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

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return this.deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public ResponseData date(String date) {
        setDate(date);
        return this;
    }

    public ResponseData confirmed_diff(int confirmed_diff) {
        setConfirmed_diff(confirmed_diff);
        return this;
    }

    public ResponseData active_diff(int active_diff) {
        setActive_diff(active_diff);
        return this;
    }

    public ResponseData deaths_diff(int deaths_diff) {
        setDeaths_diff(deaths_diff);
        return this;
    }

    public ResponseData recovered(int recovered) {
        setRecovered(recovered);
        return this;
    }

    public ResponseData recovered_diff(int recovered_diff) {
        setRecovered_diff(recovered_diff);
        return this;
    }

    public ResponseData fatality_rate(double fatality_rate) {
        setFatality_rate(fatality_rate);
        return this;
    }

    public ResponseData last_update(String last_update) {
        setLast_update(last_update);
        return this;
    }

    public ResponseData active(long active) {
        setActive(active);
        return this;
    }

    public ResponseData iso(String iso) {
        setIso(iso);
        return this;
    }

    public ResponseData province(String province) {
        setProvince(province);
        return this;
    }

    public ResponseData cities(String[] cities) {
        setCities(cities);
        return this;
    }

    public ResponseData name(String name) {
        setName(name);
        return this;
    }

    public ResponseData lat(String lat) {
        setLat(lat);
        return this;
    }

    public ResponseData lon(String lon) {
        setLon(lon);
        return this;
    }

    public ResponseData confirmed(String confirmed) {
        setConfirmed(confirmed);
        return this;
    }

    public ResponseData deaths(String deaths) {
        setDeaths(deaths);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", confirmed_diff='" + getConfirmed_diff() + "'" +
            ", active_diff='" + getActive_diff() + "'" +
            ", deaths_diff='" + getDeaths_diff() + "'" +
            ", recovered='" + getRecovered() + "'" +
            ", recovered_diff='" + getRecovered_diff() + "'" +
            ", fatality_rate='" + getFatality_rate() + "'" +
            ", last_update='" + getLast_update() + "'" +
            ", active='" + getActive() + "'" +
            ", iso='" + getIso() + "'" +
            ", province='" + getProvince() + "'" +
            ", cities='" + getCities() + "'" +
            ", name='" + getName() + "'" +
            ", lat='" + getLat() + "'" +
            ", lon='" + getLon() + "'" +
            ", confirmed='" + getConfirmed() + "'" +
            ", deaths='" + getDeaths() + "'" +
            "}";
    }




}
