# The JOIN operation

1
-

```sql
SELECT matchid, player
FROM goal
WHERE teamid = 'GER'
```

2
-

```sql
SELECT id, stadium, team1, team2
FROM game
WHERE id = 1012
```

3
-

```sql
SELECT goal.player, goal.teamid, game.stadium, game.mdate
FROM goal
JOIN game ON
goal.matchid = game.id
WHERE goal.teamid = 'GER'
```

4
-

```sql
SELECT game.team1, game.team2, goal.player
FROM game
JOIN goal ON
goal.matchid = game.id
WHERE goal.player LIKE 'Mario%'
```

5
-

```sql
SELECT goal.player, goal.teamid, eteam.coach, goal.gtime
FROM goal
JOIN eteam ON
goal.teamid = eteam.id
WHERE goal.gtime <= 10
 ```

6
-

```sql
SELECT game.mdate, eteam.teamname
FROM game
JOIN eteam ON
( game.team1 = eteam.id )
WHERE eteam.coach = 'Fernando Santos'
```

7
-

```sql
SELECT goal.player
FROM goal
JOIN game ON
goal.matchid = game.id
WHERE game.stadium = 'National Stadium, Warsaw'
```

8
-

```sql
SELECT DISTINCT goal.player
FROM game
JOIN goal ON
goal.matchid = game.id
WHERE( game.team1 = 'GER'
OR game.team2 = 'GER' )
AND goal.teamid <> 'GER'
```

9
-

```sql
SELECT eteam.teamname, COUNT( goal.teamid )
FROM eteam
JOIN goal ON
eteam.id = goal.teamid
GROUP BY eteam.teamname
```

10
--

```sql
SELECT game.stadium, COUNT( goal.matchid )
FROM game
JOIN goal ON
goal.matchid = game.id
GROUP BY game.stadium
```

11
--

SQLZOO has `ONLY_FULL_GROUP_BY` enabled and so we need to specify all
non-agregate columns in the `GROUP BY`.

```sql
SELECT
  game.id,
  game.mdate,
  COUNT( goal.matchid )
FROM
  game
JOIN goal ON
  game.id = goal.matchid
WHERE
  game.team1 = 'POL'
  OR game.team2 = 'POL'
GROUP BY
  game.id,
  game.mdate
```

12
--

```sql
SELECT
  game.id,
  game.mdate,
  COUNT( goal.teamid )
FROM
  game
JOIN goal ON
  game.id = goal.matchid
WHERE
  goal.teamid = 'GER'
GROUP BY
  game.id,
  game.mdate
```

13
--

```sql
SELECT
  game.mdate,
  game.team1,
  SUM( CASE WHEN goal.teamid = game.team1 THEN 1 ELSE 0 END ) AS score1,
  game.team2,
  SUM( CASE WHEN goal.teamid = game.team2 THEN 1 ELSE 0 END ) AS score2
FROM
  game
LEFT JOIN goal ON
  game.id = goal.matchid
GROUP BY
  game.mdate,
  game.team2,
  game.team1
```
