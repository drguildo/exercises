# More JOIN operations

1962 movies
-----------

```sql
SELECT
  id,
  title
FROM
  movie
WHERE
  yr = 1962
```

When was Citizen Kane released?
-------------------------------

```sql
SELECT
  yr
FROM
  movie
WHERE
  title = 'Citizen Kane'
```

Star Trek movies
----------------

```sql
SELECT
  id,
  title,
  yr
FROM
  movie
WHERE
  title LIKE 'Star Trek%'
```

id for actor Glenn Close
------------------------

```sql
SELECT
  id
FROM
  actor
WHERE
  name = 'Glenn Close'
```

id for Casablanca
-----------------

```sql
SELECT
  id
FROM
  movie
WHERE
  title = 'Casablanca'
```

Cast list for Casablanca
------------------------

```sql
SELECT
  name
FROM
  actor
JOIN casting ON
  actor.id = casting.actorid
WHERE
  casting.movieid =(
    SELECT
      id
    FROM
      movie
    WHERE
      title = 'Casablanca'
  )
```

Alien cast list
---------------

```sql
SELECT
  actor.name
FROM
  movie
JOIN casting ON
  movie.id = casting.movieid
JOIN actor ON
  casting.actorid = actor.id
WHERE
  movie.title = 'Alien'
```

Harrison Ford movies
--------------------

```sql
SELECT
  movie.title
FROM
  actor
JOIN casting ON
  actor.id = casting.actorid
JOIN movie ON
  casting.movieid = movie.id
WHERE
  actor.name = 'Harrison Ford'
```

Harrison Ford as a supporting actor
-----------------------------------

```sql
SELECT
  movie.title
FROM
  actor
JOIN casting ON
  actor.id = casting.actorid
JOIN movie ON
  casting.movieid = movie.id
WHERE
  actor.name = 'Harrison Ford'
  AND casting.ord > 1
```

Lead actors in 1962 movies
--------------------------

```sql
SELECT
  movie.title,
  actor.name
FROM
  movie
JOIN casting ON
  movie.id = casting.movieid
JOIN actor ON
  casting.actorid = actor.id
WHERE
  movie.yr = 1962
  AND casting.ord = 1
```

Busy years for John Travolta
----------------------------

```sql
SELECT
  movie.yr,
  COUNT( movie.yr )
FROM
  actor
JOIN casting ON
  casting.actorid = actor.id
JOIN movie ON
  movie.id = casting.movieid
WHERE
  actor.name = 'John Travolta'
GROUP BY
  movie.yr
HAVING
  COUNT( movie.yr )> 2
```

Lead actor in Julie Andrews movies
----------------------------------

```sql
SELECT
  movie.title,
  actor.name
FROM
  actor
JOIN casting ON
  actor.id = casting.actorid
JOIN movie ON
  movie.id = casting.movieid
WHERE
  movie.id IN(
    SELECT
      movieid
    FROM
      casting
    WHERE
      actorid =(
        SELECT
          id
        FROM
          actor
        WHERE
          name = 'Julie Andrews'
      )
  )
  AND casting.ord = 1
```

Actors with 30 leading roles
----------------------------

```sql
SELECT
  actor.name
FROM
  actor
JOIN casting ON
  actor.id = casting.actorid
WHERE
  casting.ord = 1
GROUP BY
  actor.name
HAVING
  COUNT( actor.name )>= 30
ORDER BY
  actor.name
```

14
--

```sql
SELECT
  movie.title,
  COUNT( movie.id )
FROM
  movie
JOIN casting ON
  casting.movieid = movie.id
WHERE
  movie.yr = 1978
GROUP BY
  movie.id,
  movie.title
ORDER BY
  COUNT( movie.id ) DESC,
  movie.title
```

15
--

```sql
SELECT
  DISTINCT actor.name
FROM
  actor
JOIN casting ON
  casting.actorid = actor.id
WHERE
  actor.name != 'Art Garfunkel'
  AND casting.movieid IN(
    SELECT
      movieid
    FROM
      casting
    WHERE
      actorid =(
        SELECT
          id
        FROM
          actor
        WHERE
          name = 'Art Garfunkel'
      )
  )
```
