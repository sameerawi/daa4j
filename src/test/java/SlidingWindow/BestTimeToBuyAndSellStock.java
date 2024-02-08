package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock
{

    public int maxProfit(int[] prices)
    {
        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = 0;

        int buy = prices[0] * -1;

        for(int i=1; i<prices.length; i++)
        {
            currentProfit = Math.max(currentProfit, buy + prices[i]);

            buy = Math.max(buy, prices[i] * -1);

            maxProfit = Math.max(currentProfit, maxProfit);
        }

        return maxProfit;
    }

    @Test
    public void test()
    {
        assert (5 == maxProfit(new int[]{7,1,5,3,6,4}));
        assert (0 == maxProfit(new int[]{7,6,4,3,1}));
    }
}
