package dsalgo.company.atlassian;

import com.just.code.dsalgo.company.atlassian.MostPopularImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MostPopularImplTest {
    MostPopularImpl popularityTracker = new MostPopularImpl();

    @Test
    void testMostPopular() {
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 7);        // returns 7
        popularityTracker.increasePopularity(8);
        popularityTracker.increasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 8);       // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 7);        // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), -1);        // returns -1 since
    }

    @Test
    void testMostPopular2() {
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 7);        // returns 7
        popularityTracker.increasePopularity(8);
        popularityTracker.increasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 8);       // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 7);        // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        //popularityTracker.decreasePopularity(8);
        Assertions.assertEquals(popularityTracker.mostPopular(), 8);        // returns -1 since
    }
}