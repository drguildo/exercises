# SUM and COUNT

Total world population
----------------------

```sql
SELECT SUM(population) FROM world
```

List of continents
------------------

```sql
SELECT DISTINCT continent FROM world
```

GDP of Africa
-------------

```sql
SELECT SUM(gdp) FROM world WHERE continent = 'Africa'
```

Count the big countries
-----------------------

```sql
SELECT COUNT(name) FROM world WHERE area >= 1000000
```

Baltic states population
------------------------

```sql
SELECT SUM(population) FROM world WHERE name IN ('Estonia', 'Latvia', 'Lithuania')
```

Counting the countries of each continent
----------------------------------------

```sql
SELECT continent, COUNT(continent) FROM world GROUP BY continent
```

Counting big countries in each continent
----------------------------------------

```sql
SELECT continent, COUNT(name) FROM world
  WHERE population >= 10000000 GROUP BY continent
```

Counting big continents
-----------------------

```sql
SELECT continent FROM world
  GROUP BY continent HAVING SUM(population) >= 100000000
```
