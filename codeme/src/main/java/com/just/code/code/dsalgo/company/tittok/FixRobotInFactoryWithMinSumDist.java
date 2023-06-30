package dsalgo.company.tittok;

public class FixRobotInFactoryWithMinSumDist {
    static int[] rLoc;
    static int[][] factories;
    static int minCost = Integer.MAX_VALUE;

//    there are m robots and n factories located in the same line.
//    You will be receiving 2 input parameters robots and factories, where robots are a list of integers
//    m1, m2 ... mk specifying the location of the robot, and the factories are a list of integer arrays with length 2 [n1, l1], [n2, l2] ... [ni, li]
//    speicifying the location of the factory and the number of robots that the factories can repair.
//    All robots are initially broken and you need to return the minimum sum of disatnces that travel all robots to factories for repairing.
//    The distance between a robot and a factory is the absolute value of the difference between the location of the robot and the location of the
/*
    example:
robot [2, 6, 10]
factories [[4,2][1,3]]
return 4 ((4-2) + (6 - 4))

2 + 2 + 5 ->



-10 ^ 9 <= mi,ni <= 10^9
it is guaranteed that all robots can be repaired in the given input.


        */

    public static int getMinSumToRepair(int[] robots, int[][] facts) {
        rLoc = robots;
        factories = facts;
        dp(0, 0,0,0, factories);
        return minCost;
    }

    private static void dp(int r, int fixed, int f, int cost, int[][] updatedFac) {
        if(r == rLoc.length && fixed == rLoc.length) {
            minCost = Math.min(minCost, cost);
            return;
        }
        if(r >= rLoc.length || f >= factories.length) {
            return;
        }
        for(int[] fac : updatedFac) {
            int cap = factories[f][1];
            if (cap > 0) {
                int dist = Math.abs(rLoc[r] - factories[f][0]);
                updatedFac[f][1]--;
                dp(r + 1, fixed + 1, f + 1, cost + dist, updatedFac);
                updatedFac[f][1]++;
                dp(r + 1, fixed, f, cost, updatedFac);
            }
        }
    }



    public static void main(String[] args) {
        int[] robots = {2,6};
        int[][] fac = new int[][] {{4,2}};
        int minSumToRepair = getMinSumToRepair(robots, fac);
        System.out.println(minSumToRepair);
    }

}
