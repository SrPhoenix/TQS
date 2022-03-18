package tqs.lab2;

//import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.BeforeAll.*;
//import static org.junit.jupiter.api.BeforeEach.*;
//import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


//Let's import Mockito statically so that the code looks clearer

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class StocksPortfolioTest 
{

    @Mock private IStockmarketService mockedMarket ;
    @InjectMocks private StocksPortfolio sp;

    @Test
    public void getTotalValue(){
        when(mockedMarket.lookUpPrice("Apple")).thenReturn(240.50);
        when(mockedMarket.lookUpPrice("Android")).thenReturn(200.15);

        sp.addStock(new Stock("Apple",2));
        sp.addStock(new Stock("Android",10));

        // total = 2* 240.50 + 10 * 200.15 = 2482.5
        assertEquals(2482.5, sp.getTotalValue());

        verify(mockedMarket, times(2));
        verify(mockedMarket).lookUpPrice("Apple");
        verify(mockedMarket).lookUpPrice("Android");


    } 

    @Test
    public void getTotalValueKai(){
        when(mockedMarket.lookUpPrice("Apple")).thenReturn(240.50);
        when(mockedMarket.lookUpPrice("Android")).thenReturn(200.15);

        sp.addStock(new Stock("Apple",2));
        sp.addStock(new Stock("Android",10));

        // total = 2* 240.50 + 10 * 200.15 = 2482.5
        assertThat(sp.getTotalValue(), is(2482.5) );

        verify(mockedMarket, times(2));
        verify(mockedMarket).lookUpPrice("Apple");
        verify(mockedMarket).lookUpPrice("Android");


    } 
}
