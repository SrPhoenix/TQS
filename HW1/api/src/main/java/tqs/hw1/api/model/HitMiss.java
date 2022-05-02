package tqs.hw1.api.model;

public class HitMiss {
    private int hit = 0;
    private int miss = 0;

    public HitMiss() {
    }

    public HitMiss( int hit, int miss) {
        this.hit = hit;
        this.miss = miss;
    }

    public int getTotal() {
        return this.hit+miss;
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

    public void plusHit() {
        hit++;
    }
    public void plusMiss() {
        miss++;
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
