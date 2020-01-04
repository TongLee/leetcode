/**
 * 
 */
package com.tonglee.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/* *
  * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
  * 数字 1-9 在每一行只能出现一次。
  * 数字 1-9 在每一列只能出现一次。
  * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
  * 说明:
  * 一个有效的数独（部分已被填充）不一定是可解的。
  * 只需要根据以上规则，验证已经填入的数字是否有效即可。
  * 给定数独序列只包含数字 1-9 和字符 '.' 。
  * 给定数独永远是 9x9 形式的。
  * 链接：https://leetcode-cn.com/problems/valid-sudoku/

 * @author lit
 * @version 1.0
 * 2019年11月24日 下午10:01:59
 */
/**
 * @author tonglee
 *
 */
public class ValidSudoku {
//	执行用时 :4 ms, 在所有 java 提交中击败了72.74% 的用户
//	内存消耗 :43.3 MB, 在所有 java 提交中击败了75.38%的用户
	public boolean isValidSudoku(char[][] board) {
		char nan = '.';
		Set<Character>[] setsLine = new HashSet[9];
		Set<Character>[] setsStreet = new HashSet[9];
		Set<Character>[] setsMini = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char tmp = board[i][j];
				if (tmp == nan)
					continue;
				if (setsLine[i] == null)
					setsLine[i] = new HashSet<Character>();
				if (!setsLine[i].add(tmp))
					return false;
				if (setsStreet[j] == null)
					setsStreet[j] = new HashSet<Character>();
				if (!setsStreet[j].add(tmp))
					return false;
//				int pos = cal(i,j);
				int pos = i/3 + (j/3 * 3);
				if (setsMini[pos] == null)
					setsMini[pos] = new HashSet<Character>();
				if (!setsMini[pos].add(tmp))
					return false;
			}
		}

		return true;
	}
//	执行用时 :2 ms, 在所有 java 提交中击败了97.69% 的用户
//	内存消耗 :42.5 MB, 在所有 java 提交中击败了80.38%的用户
	public boolean isValidSudoku2(char[][] board) {
		char nan = '.';
		int[][] setsLine = new int[9][9];
		int[][] setsStreet = new int[9][9];
		int[][] setsMini = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char tmp = board[i][j];
				if (tmp == nan)
					continue;
				int y = tmp - '1';
				if ((setsLine[i][y]++)>=1)
					return false;
				if ((setsStreet[j][y]++)>=1)
					return false;
//				int pos = cal(i,j);
				// 让代码更简洁，但是不影响效率·
				int pos = i/3 + (j/3 * 3);
				if ((setsMini[pos][y]++)>=1)
					return false;
			}
		}

		return true;
	}
	
	/** 
	* @Description 
	* @params
	* @return 
	* @date 2019年11月24日 下午10:23:40
	* @throws 
	*/
	private int cal(int i, int j) {
		if (i < 3 && j < 3)
			return 0;
		else if (i < 6 && j < 3)
			return 1;
		else if (i < 9 && j < 3)
			return 2;
		else if (i < 3 && j < 6)
			return 3;
		else if (i < 6 && j < 6)
			return 4;
		else if (i < 9 && j < 6)
			return 5;
		else if (i < 3 && j < 9)
			return 6;
		else if (i < 6 && j < 9)
			return 7;
		else
			return 8;
	}
}
