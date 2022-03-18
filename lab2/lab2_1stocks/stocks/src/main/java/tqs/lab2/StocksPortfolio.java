package tqs.lab2;

import java.util.List;
import java.util.ArrayList;

public class StocksPortfolio {
    private List<Stock> stocks = new ArrayList<Stock>();
    private IStockmarketService stockmarket;

    public StocksPortfolio(IStockmarketService stockmarket){
        this.stockmarket = stockmarket;
    }
    public void addStock(Stock s){
        stocks.add(s);
    }
    public double getTotalValue(){
        Double total= 0.0;
        for (Stock s: stocks){
            total += stockmarket.lookUpPrice(s.getLabel());
        }
        return total;
    }

}
