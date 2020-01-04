/**
 * 
 */
package com.tonglee.leetcode.array;
/* *
  * 给定一个 n × n 的二维矩阵表示一个图像。
  * 将图像顺时针旋转 90 度。
  * 说明：
  * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
  * 链接：https://leetcode-cn.com/problems/rotate-image/
  * 
 * @author lit
 * @version 1.0
 * 2019年11月25日 下午8:40:30
 */
/**
 * @author tonglee
 *
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * 
 * 13  9  5  1
 * 14 10  6  2
 * 15 11  7  3
 * 16 12  8  4
 */
public class RotateImage {
//	执行用时 :0 ms, 在所有 java 提交中击败了100.00% 的用户
//	内存消耗 :35.9 MB, 在所有 java 提交中击败了61.53%的用户
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		int half = len/2;
		int mod = len%2;
		for (int i=0; i<half; i++) {
			for (int j=0; j<half+mod; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len-j-1][i];
				matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
				matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
				matrix[j][len-i-1] = tmp;
			}
		}
	}
	// 方法 1 ：转置加翻转
	//最直接的想法是先转置矩阵，然后翻转每一行。这个简单的方法已经能达到最优的时间复杂度O(N^2)。——上下变换+左右变换
	public void rotate1(int[][] matrix) {
	    int n = matrix.length;

	    // transpose matrix
	    for (int i = 0; i < n; i++) {
	      for (int j = i; j < n; j++) {
	        int tmp = matrix[j][i];
	        matrix[j][i] = matrix[i][j];
	        matrix[i][j] = tmp;
	      }
	    }
	    // reverse each row
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < n / 2; j++) {
	        int tmp = matrix[i][j];
	        matrix[i][j] = matrix[i][n - j - 1];
	        matrix[i][n - j - 1] = tmp;
	      }
	    }
	  }
	//方法 2 ：旋转四个矩形
//	时间复杂度：O(N2)O(N^2)O(N2) 是两重循环的复杂度。
//	空间复杂度：O(1)O(1)O(1) 由于我们在一次循环中的操作是 就地 完成的，并且我们只用了长度为 4 的临时列表做辅助。
	// 借用了临时数组
	public void rotate2(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2 + n % 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int[] tmp = new int[4];
				int row = i;
				int col = j;
				for (int k = 0; k < 4; k++) {
					tmp[k] = matrix[row][col];
					int x = row;
					row = col;
					col = n - 1 - x;
				}
				for (int k = 0; k < 4; k++) {
					matrix[row][col] = tmp[(k + 3) % 4];
					int x = row;
					row = col;
					col = n - 1 - x;
				}
			}
		}
	}
	//方法 3：在单次循环中旋转 4 个矩形
	public void rotate3(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}
	
}
