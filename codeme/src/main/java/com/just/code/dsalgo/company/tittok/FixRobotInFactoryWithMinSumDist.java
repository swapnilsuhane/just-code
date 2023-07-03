package com.just.code.dsalgo.company.tittok;

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
        dp(0,0, 0, factories);
        return minCost;
    }

    private static void dp(int r, int f, int cost, int[][] updatedFac) {
        if(r == rLoc.length) {
            minCost = Math.min(minCost, cost);
            return;
        }
        for(int i=f; i<updatedFac.length; i++) {
            if (updatedFac[i][1] > 0) {
                int dist = Math.abs(rLoc[r] - updatedFac[i][0]);
                int[][] newFac = updatedFac;
                newFac[i][1]--;
                dp(r + 1, f,cost + dist, newFac);
                newFac[i][1]++;
                dp(r , f+1, cost, updatedFac);
            }
        }
    }

    public static void main(String[] args) {
        int[] robots = {2,6};
        int[][] fac = new int[][] {{4,2},{3,2},{2,1},{5,1}};
        int minSumToRepair = getMinSumToRepair(robots, fac);
        System.out.println(minSumToRepair);
    }

}
