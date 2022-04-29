package tqs.hw1.api.model;

import java.util.ArrayList;

public class ResponseDataArray {
    public ArrayList<ResponseData> data = new ArrayList<>();

    public ResponseData get(int index){
        return data.get(index);
    }

    public void add(ResponseData info){
         data.add(info);
    }

    public int size(){
        return data.size();
    }




    public ArrayList<ResponseData> getData() {
        return this.data;
    }

    public void setData(ArrayList<ResponseData> data) {
        this.data = data;
    }

    public ResponseDataArray data(ArrayList<ResponseData> data) {
        setData(data);
        return this;
    }






    @Override
    public String toString() {
        return "{" +
            " data='" + data.toString() + "'" +
            "}";
    }

}
