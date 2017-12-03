## 미로 찾기
---

> recursion을 이용해 미로의 출구를 찾아보기


### Pseudocode

![pseudocode](./pseudocode)

### final 변수 설명

* PATHWAY_COLOUR : unvisited 이며 앞으로 갈 수 있는 cell

* WALL_COLOUR : 막혀서 갈 수 없는 cell

* PATH_COLOUR : visited 이며 아직 출구로 가는 경로가 될 가능성이 있는 cell

* BLOCKED_COLOUR : visited 이며 출구까지의 경로상에 있지 않음이 밝혀진 cell


### 움직인 경로

![움직인경로](./resultPath)

```java
else {
			maze[x][y] = PATH_COLOUR;
			if (findMazePath(x - 1, y) || findMazePath(x, y + 1)
					|| findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
				return true;
			}
			maze[x][y] = BLOCKED_COLOUR;
			return false;
		}
```

위의 code에서는 북, 동, 남, 서 순서로 경로를 탐색하도록 설계되어 있다
