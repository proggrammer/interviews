package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatedSortedArrayTest {

    @Test
    void findMin() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = RotatedSortedArray.findMin(nums);
        Assertions.assertEquals(min, 0);
    }

    @Test
    void search()   {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = RotatedSortedArray.search(nums, target);

        Assertions.assertEquals(index, 4);
    }
}