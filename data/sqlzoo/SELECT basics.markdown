# SELECT basics

Introducing the world table of countries
----------------------------------------

```sql
SELECT population FROM world
  WHERE name = 'Germany'
```

Scandinavia
-----------

```sql
SELECT name, population FROM world
  WHERE name IN ('Sweden', 'Norway', 'Denmark');
```

Just the right size
-------------------

```sql
SELECT name, area FROM world
  WHERE area BETWEEN 200000 AND 250000
```
