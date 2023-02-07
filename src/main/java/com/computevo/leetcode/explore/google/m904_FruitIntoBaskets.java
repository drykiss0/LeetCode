package com.computevo.leetcode.explore.google;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/fruit-into-baskets/description/">link</a>
 */
public class m904_FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int[] basketCounts = new int[2];
        int[] basketTypes = new int[]{-1, -1};
        int currentBasket = 0;
        int maxSoFar = 0;
        int fruitsSinceLastBasketChange = 0;
        for (int fruit : fruits) {
            if (basketTypes[1 - currentBasket] == fruit) {
                fruitsSinceLastBasketChange = 0;
                currentBasket = 1 - currentBasket;
            } else if (basketTypes[currentBasket] != fruit) {
                maxSoFar = Math.max(maxSoFar, basketCounts[0] + basketCounts[1]);
                basketCounts[currentBasket] = fruitsSinceLastBasketChange;
                currentBasket = 1 - currentBasket;
                basketTypes[currentBasket] = fruit;
                basketCounts[currentBasket] = 0;
                fruitsSinceLastBasketChange = 0;
            }
            basketCounts[currentBasket]++;
            fruitsSinceLastBasketChange++;
        }

        return Math.max(maxSoFar, basketCounts[0] + basketCounts[1]);
    }

    public static void main(String[] args) {

        int[] fruits1 = {0, 0, 1, 1};
        int[] fruits2 = {1, 0, 1, 4, 1, 4, 1, 2, 3};
        int[] fruits3 = {1, 2, 3, 2, 2};

        printInput("fruits", new Object[]{fruits1, fruits2, fruits3});
        printOutput(
                "totalFruit1", new m904_FruitIntoBaskets().totalFruit(fruits1),
                "totalFruit2", new m904_FruitIntoBaskets().totalFruit(fruits2),
                "totalFruit3", new m904_FruitIntoBaskets().totalFruit(fruits3)
        );
    }
}
