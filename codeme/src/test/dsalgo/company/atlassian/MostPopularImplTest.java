package dsalgo.company.atlassian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MostPopularImplTest {
    MostPopular popularityTracker = new MostPopularImpl();

    @Test
    void testMostPopular() {
        MostPopular popularityTracker = new MostPopularImpl();
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
        MostPopular popularityTracker = new MostPopularImpl();
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