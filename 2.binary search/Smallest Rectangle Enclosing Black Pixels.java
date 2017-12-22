/*
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

Have you met this question in a real interview? Yes
Example
For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Tags 
Binary Search Google
*/
public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if (image == null || image.length == 0) {
            return 0;
        }
        int firstRow = findFirstRow(image, x);
        int lastRow = findLastRow(image, x);
        int firstColumn = findFirstColumn(image, y);
        int lastColumn = findLastColumn(image, y);
        return (lastRow - firstRow + 1) * (lastColumn - firstColumn + 1);
    }
    private int findFirstRow(char[][] image, int x) {
        int start = 0, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (checkRow(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (checkRow(image, start)) {
            return start;
        }
        else {
            return end;
        }
    }
    private int findLastRow(char[][] image, int x) {
        int start = x, end = image.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (checkRow(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (checkRow(image, end)) {
            return end;
        }
        else {
            return start;
        }
    }
    private int findFirstColumn(char[][] image, int y) {
        int start = 0, end = y;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (checkColumn(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (checkColumn(image, start)) {
            return start;
        }
        else {
            return end;
        }
    }
    private int findLastColumn(char[][] image, int y) {
        int start = y, end = image[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (checkColumn(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (checkColumn(image, end)) {
            return end;
        }
        else {
            return start;
        }
    }
    private boolean checkRow(char[][] image, int row) {
        for (int j = 0; j < image[row].length; j ++) {
            if (image[row][j] == '1') {
                return true;
            }
        }
        return false;
    }
    private boolean checkColumn(char[][] image, int column) {
        for (int i = 0; i < image.length; i ++) {
            if (image[i][column] == '1') {
                return true;
            }
        }
        return false;
    }
}