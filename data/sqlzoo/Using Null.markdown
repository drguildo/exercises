# Using Null

1
-

```sql
SELECT
  name
FROM
  teacher
WHERE
  dept IS NULL
```

2
-

```sql
SELECT
  teacher.name,
  dept.name
FROM
  teacher
INNER JOIN dept ON
  teacher.dept = dept.id
```

3
-

```sql
SELECT
  teacher.name,
  dept.name
FROM
  teacher
LEFT JOIN dept ON
  teacher.dept = dept.id
```

4
-

```sql
SELECT
  teacher.name,
  dept.name
FROM
  teacher
RIGHT JOIN dept ON
  teacher.dept = dept.id
```

5
-

```sql
SELECT
  name,
  COALESCE(
    mobile,
    '07986 444 2266'
  )
FROM
  teacher
```

6
-

```sql
SELECT
  teacher.name,
  COALESCE(
    dept.name,
    'None'
  )
FROM
  teacher
LEFT JOIN dept ON
  teacher.dept = dept.id
```

7
-

```sql
SELECT
  COUNT( name ),
  COUNT( mobile )
FROM
  teacher
```

8
-

```sql
SELECT
  dept.name,
  COUNT( teacher.name )
FROM
  teacher
RIGHT JOIN dept ON
  teacher.dept = dept.id
GROUP BY
  dept.name
```

9
-

```sql
SELECT
  name,
  CASE
    WHEN(
      teacher.dept = 1
      OR teacher.dept = 2
    ) THEN 'Sci'
    ELSE 'Art'
  END
FROM
  teacher
```

10
--

```sql
SELECT
  name,
  CASE
    WHEN(
      teacher.dept = 1
      OR teacher.dept = 2
    ) THEN 'Sci'
    WHEN teacher.dept = 3 THEN 'Art'
    ELSE 'None'
  END AS Department
FROM
  teacher
```
