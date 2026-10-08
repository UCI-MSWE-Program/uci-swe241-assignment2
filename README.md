# Assignment 2: Binary Search

Java implementation of the two tasks for SWE 241 Assignment 2: finding
the first and last position of a target value in a sorted array, and
searching a sorted 2D matrix, both in logarithmic time. Each task
includes JUnit 5 sample test cases. Both classes are implemented from
scratch.

[TOC]

## Task 1: Find first and last position of target

Given an array of integers `nums` sorted in non-decreasing order, find a
given target value's first and last position. If the target is not found
in the array, return `[-1, -1]`. The algorithm must run in O(log n)
time.

```text
Input: nums = [4,9,10,13,17,17,19,21], target = 17
Output: [4,5]

Input: nums = [2,4,6,8,10,14,16], target = 12
Output: [-1,-1]

Input: nums = [], target = 0
Output: [-1,-1]
```

Implementation: [src/main/java/Task1.java](src/main/java/Task1.java)
runs two binary searches over the array: one that keeps searching left
after a match to find the first occurrence, and one that keeps searching
right to find the last occurrence. The total runtime is O(log n) with
O(1) space. A target that appears exactly once returns `[i, i]`; an
absent target returns `[-1, -1]`.

### Task 1 sample test cases

`src/test/java/Task1Test.java` validates:

*   The three assignment examples.
*   Empty and single-element arrays.
*   A single occurrence of the target returns its position.
*   Duplicates at the start, middle, and end of the array.
*   An array where every element equals the target.
*   Targets smaller and larger than every element.
*   Negative numbers.
*   A 1,000-element array with many duplicates.

## Task 2: Search a 2D matrix

Given an m x n integer matrix where each row is sorted in non-decreasing
order and the first integer of each row is greater than the last integer
of the previous row, return true if the target is in the matrix or false
otherwise. The solution must run in O(log(m * n)) time.

```text
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

Implementation: [src/main/java/Task2.java](src/main/java/Task2.java)
treats the matrix as a single sorted sequence of rows laid end to end
and binary-searches the flattened indices, giving O(log(m * n)) time and
O(1) space. Empty matrices and matrices with empty rows return `false`.

### Task 2 sample test cases

`src/test/java/Task2Test.java` validates:

*   The two assignment examples.
*   Empty matrix and a matrix with an empty row.
*   Single-element, single-row, and single-column matrices.
*   Targets at the first and last positions of the matrix.
*   Targets between rows and outside the value range.
*   Non-square matrices and negative numbers.
*   A 100 x 100 matrix with values 0 through 9,999.

## Build and test

Requires JDK 25 or newer. Build and run the tests with the Gradle
wrapper:

```shell
./gradlew build
./gradlew test
```

## Project layout

```text
src/main/java/Task1.java
src/main/java/Task2.java
src/test/java/Task1Test.java
src/test/java/Task2Test.java
```
