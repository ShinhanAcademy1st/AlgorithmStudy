package com.shinhan.education;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n, m;
	static int minDistance = 1000000000;
	static int numOfChickenHouses;
	static int numOfHouses;
	static int [][] chickenMap;
	static int [][] chickenHouses = new int[13][2];
	static int [][] pickedChickenHouses;
	static int [] dx = { -1, 1, 0, 0 };
	static int [] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		init();
		findMinChickenDistance(0, 0);
		System.out.println(minDistance);
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chickenMap = new int[n][n];
		pickedChickenHouses = new int[13][2];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				chickenMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		int chickenHouseIndex = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (chickenMap[i][j] == 1) {
					++numOfHouses;
				}
				else if (chickenMap[i][j] == 2) {
					++numOfChickenHouses;
					chickenHouses[chickenHouseIndex][0] = i;
					chickenHouses[chickenHouseIndex][1] = j;
					++chickenHouseIndex;
				}
			}
		}
	}
	
	static void findMinChickenDistance(int index, int chickenHouseCount) {
		if (chickenHouseCount == m) {
			calculateChickenDistance();
		}
		if (index == numOfChickenHouses) {
			return;
		}
		if (numOfChickenHouses - index < m - chickenHouseCount) {
			return;
		}
		for (; index < numOfChickenHouses; ++index) {
			pickedChickenHouses[chickenHouseCount][0] = chickenHouses[index][0];
			pickedChickenHouses[chickenHouseCount][1] = chickenHouses[index][1];
			findMinChickenDistance(index + 1, chickenHouseCount + 1);
		}
	}

	static void calculateChickenDistance() {
		Queue<Integer> xQueue = new LinkedList<>();
		Queue<Integer> yQueue = new LinkedList<>();
		boolean [][] visited = new boolean[n][n];
		int [][] distance = new int[n][n];
		int curDistance = 0;
		int visitedHouseCount = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				visited[i][j] = false;
				distance[i][j] = 0;
			}
		}
		for (int i = 0; i < m; ++i) {
			int x = pickedChickenHouses[i][0];
			int y = pickedChickenHouses[i][1];
			xQueue.add(x);
			yQueue.add(y);
			visited[x][y] = true;;
		}
		while (!xQueue.isEmpty()) {
			int row = xQueue.poll();
			int col = yQueue.poll();
			for (int i = 0; i < 4; ++i) {
				int nextRow = row + dx[i];
				int nextCol = col + dy[i];
				if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
					continue;
				}
				if (visited[nextRow][nextCol]) {
					continue;
				}
				distance[nextRow][nextCol] = distance[row][col] + 1;
				if (chickenMap[nextRow][nextCol] == 1) {
					++visitedHouseCount;
					curDistance += distance[nextRow][nextCol];
				}
				visited[nextRow][nextCol] = true;
				xQueue.offer(nextRow);
				yQueue.offer(nextCol);
			}
			if (visitedHouseCount == numOfHouses) {
				break;
			}
		}
		if (curDistance < minDistance) {
			minDistance = curDistance;
		}
	}
}