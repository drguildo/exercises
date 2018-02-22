# SELECT within SELECT

Bigger than Russia
------------------

```sql
SELECT name FROM world
  WHERE population > (SELECT population FROM world WHERE name='Russia')
```

Richer than UK
--------------

```sql
SELECT name FROM world
  WHERE continent = 'Europe'
  AND gdp/population > (SELECT gdp/population FROM world
                          WHERE name = 'United Kingdom')
```

Neighbours of Argentina and Australia
-------------------------------------

```sql
SELECT name, continent FROM world
  WHERE continent IN (SELECT DISTINCT continent FROM world
                        WHERE name IN ('Argentina', 'Australia'))
  ORDER BY name
```

Between Canada and Poland
-------------------------

```sql
SELECT name, population FROM world
  WHERE population > (SELECT population FROM world WHERE name = 'Canada')
  AND population < (SELECT population FROM world WHERE name = 'Poland')
```

Percentages of Germany
----------------------

```sql
SELECT name,
       CONCAT(ROUND(population/(SELECT population FROM world
                                  WHERE name = 'Germany') * 100, 0), '%')
         AS PercentageOfGermany
  FROM world
  WHERE continent = 'Europe'
```

Bigger than every country in Europe
-----------------------------------

```sql
SELECT name FROM world
  WHERE gdp > ALL (SELECT gdp FROM world WHERE continent = 'Europe' AND gdp > 0)
```

Largest in each continent
-------------------------

```sql
SELECT continent, name, area FROM world x
  WHERE area >= ALL (SELECT area FROM world y
                       WHERE y.continent = x.continent AND area > 0)
```

First country of each continent (alphabetically)
------------------------------------------------

```sql
SELECT continent, name FROM world x
  WHERE name <= ALL (SELECT name FROM world y WHERE x.continent = y.continent)
```

Difficult Questions That Utilize Techniques Not Covered In Prior Sections
-------------------------------------------------------------------------

```sql
SELECT name, continent, population FROM world x
  WHERE 25000000 >= ALL (SELECT population FROM world y WHERE x.continent = y.continent)
```

```sql
SELECT name, continent FROM world x
  WHERE population > ALL (SELECT 3 * population FROM world y
                            WHERE x.continent = y.continent AND x.name <> y.name)
```