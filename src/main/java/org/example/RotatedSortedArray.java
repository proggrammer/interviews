package org.example;

/**
 * Rotated sorted array - search for lowest number & search for a number.
 */
public class RotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated, return the first element
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the mid element is greater than the element to its right
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Check if the mid element is less than the element to its left
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // If the mid element is greater than the leftmost element, search in the right half
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else { // Otherwise, search in the left half
                right = mid - 1;
            }
        }

        // If the loop exits without finding the minimum, return nums[left]
        return nums[left];
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the mid element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target is within the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } else { // If the right half is sorted
                // Check if the target is within the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }
}
