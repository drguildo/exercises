# SELECT from WORLD

Introduction
------------

```sql
SELECT name, continent, population FROM world
```

Large Countries
---------------

```sql
SELECT name FROM world
  WHERE population >= 200000000
```

Per capita GDP
--------------

```sql
SELECT name, gdp/population FROM world
  WHERE population >= 200000000
```

South America In millions
-------------------------

```sql
SELECT name, population/1000000 FROM world
  WHERE continent = 'South America'
```

France, Germany, Italy
----------------------

```sql
SELECT name, population FROM world
  WHERE name IN ('France', 'Germany', 'Italy')
```

United
------

```sql
SELECT name FROM world
  WHERE name LIKE '%United%'
```

Two ways to be big
------------------

```sql
SELECT name, population, area FROM world
  WHERE area > 3000000 OR population > 250000000
```

One or the other (but not both)
-------------------------------

```sql
SELECT name, population, area FROM world
  WHERE area > 3000000 XOR population > 250000000
```

Rounding
--------

```sql
SELECT name, ROUND(population/1000000, 2), ROUND(gdp/1000000000, 2) FROM world
  WHERE continent = 'South America'
```

Trillion dollar economies
-------------------------

```sql
SELECT name, ROUND(gdp/population, -3) FROM world
  WHERE gdp >= 1000000000000
```

Name and capital have the same length
-------------------------------------

```sql
SELECT name, capital FROM world
  WHERE LENGTH(name) = LENGTH(capital)
```

Matching name and capital
-------------------------

```sql
SELECT name, capital FROM world
  WHERE LEFT(name, 1) = LEFT(capital, 1) AND name <> capital
```

All the vowels
--------------

```sql
SELECT name FROM world
WHERE name LIKE '%a%'
  AND name LIKE '%e%'
  AND name LIKE '%i%'
  AND name LIKE '%o%'
  AND name LIKE '%u%'
  AND name NOT LIKE '% %'
```
