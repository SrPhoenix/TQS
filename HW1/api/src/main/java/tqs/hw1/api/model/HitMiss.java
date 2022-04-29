package tqs.hw1.api.model;

public class HitMiss {
    private int total;
    private int hit;
    private int miss;

    public HitMiss() {
    }

    public HitMiss(int total, int hit, int miss) {
        this.total = total;
        this.hit = hit;
        this.miss = miss;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHit() {
        return this.hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getMiss() {
        return this.miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }



    @Override
    public String toString() {
        return "{" +
            " total='" + getTotal() + "'" +
            ", hit='" + getHit() + "'" +
            ", miss='" + getMiss() + "'" +
            "}";
    }

}
