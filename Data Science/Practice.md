### Python
#### Check None:
```python
if variable is None:
```

#### Binary tree contains:
```python
import collections

Node = collections.namedtuple('Node', ['left', 'right', 'value'])

def contains(root, value):
   if root is None:
    return False
   else:
        if root.value == value:
            return True
        elif root.value > value:
            return contains(root.left, value)
        else:
            return contains(root.right, value)
        
n1 = Node(value=1, left=None, right=None)
n3 = Node(value=3, left=None, right=None)
n2 = Node(value=2, left=n1, right=n3)
        
print(contains(n2, 3))
```
* P.S. `nameedtuple`: https://dbader.org/blog/writing-clean-python-with-namedtuples

#### Dictionary 
```python
def group_by_owners(files):
    owners = {}
    for file, name in files.items():
        if name not in owners:
            owners[name] = [file]
        else:
            owners[name].append(file)
    return owners
    
files = {
    'Input.txt': 'Randy',
    'Code.py': 'Stan',
    'Output.txt': 'Randy'
}   
print(group_by_owners(files))
```

* P.S. `dictionary`: 
https://www.w3schools.com/python/python_dictionaries.asp

https://www.geeksforgeeks.org/python-accessing-key-value-in-dictionary/


#### Reverse a string
```python
def is_palindrome(word):
    word = word.lower()
    reverse_word = word[::-1] 
    
    if word == reverse_word:
        return True
    else:
        return False
print(is_palindrome('Deleveled'))
```
* P.S. explaination of the `reverse` function: https://www.geeksforgeeks.org/reverse-string-python-5-different-ways/

#### Leap year
condition:
> In the Gregorian calendar three criteria must be taken into account to identify leap years:
>The year can be evenly divided by 4, is a leap year, unless:
>The year can be evenly divided by 100, it is NOT a leap year, unless:
>The year is also evenly divisible by 400. Then it is a leap year.

```python
def is_leap(year):
    leap = False
    
    # Write your logic here
    if year % 4 == 0:
        leap = True

    if year % 100 == 0:
        if year % 400 != 0:
            leap = False
    
        
    return leap
```

#### Substring
```python
def minion_game(string):
    # your code goes here
    length = len(string)
    index = 0
    vowels = ['A', 'E', 'I', 'O', 'U']
    Stuart = 0
    # Kevin vowels
    Kevin = 0

    for index in range(length):
        start_letter = string[index]
        if start_letter in vowels:
            points_added = length - index
            Kevin = points_added + Kevin
        else:
            points_added = length - index
            Stuart = points_added + Stuart

    if Kevin > Stuart:
        print("Kevin", Kevin)
    elif Kevin < Stuart:
        print("Stuart", Stuart)
    else:
        print("Draw")
```
* P.S. list doesn't have `get` method, to retrieve an element: list[index]

#### substring
```python
def merge_the_tools(string, k):
    # your code goes here
    sub_length = int(len(string)/k)
    length = len(string)
    substrings = []

    for index in range(0, length, sub_length):
        substring = string[index:index+sub_length] # last index is not sliced in 
        substrings.append(substring)
    
    for substring in substrings:
        new_string = []
        i = 0
        for i in range(len(substring)):
            if substring[i] not in new_string:
                new_string.append(substring[i])
            elif substring[i] in new_string and substring[i] != new_string[len(new_string)-1]:
                break

        answer = ""
        for x in range(len(new_string)):
            answer += new_string[x]

        print(answer)




if __name__ == '__main__':
    string, k = input(), int(input())
    merge_the_tools(string, k)
```

#### print without a newline
```python
print(i, end="")
```

### SQL
#### alter table
`ALTER TABLE` lets you add columns to a table in a database.
```sql
ALTER TABLE abc
ADD columnName dataType;
```
#### average
```sql
SELECT AVG(someColumn)
FROM tableName;
```

### case
`CASE` is sql way of if-else
```sql
SELECT OrderID, Quantity,
CASE
    WHEN Quantity > 30 THEN "The quantity is greater than 30"
    WHEN Quantity = 30 THEN "The quantity is 30"
    ELSE "The quantity is under 30"
END AS QuantityText
FROM OrderDetails;
```

#### order by
`ORDER BY` is a clause that indicates you want to sort the result set by a particular column either alphabetically or numerically.
```sql
SELECT CustomerName, City, Country
FROM Customers
ORDER BY
(CASE
    WHEN City IS NULL THEN Country
    ELSE City
END);
```
* P.S. `ORDER BY columnName ASC | DESC`

#### left join/outer join
An outer join will combine rows from different tables even if the join condition is not met. Every row in the left table is returned in the result set, and if the join condition is not met, then NULL values are used to fill in the columns from the right table.
```sql
SELECT columnName
FROM tableName1 LEFT JOIN tableName2 on tableName1.a = tableName2.b;
```

#### with
`WITH` clause lets you store the result of a query in a temporary table using an alias. You can also define multiple temporary tables using a comma and with one instance of the `WITH` keyword.

The `WITH` clause is also known as common table expression (CTE) and subquery factoring. 

```sql
WITH tempName AS (
    SELECT *
    FROM tableName
    WHERE someCondition
)
SELECT *
FROM tempName
WHERE columnName operator value;
```

#### group by
The `GROUP BY `statement is often used with aggregate functions (`COUNT`, `MAX`, `MIN`, `SUM`, `AVG`) to group the result-set by one or more columns.
```sql
SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country;
```

#### update values:
```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

#### Specify a range of a value:
```sql
SELECT column_name(s)
FROM table_name
WHERE column_name BETWEEN value1 AND value2;
```

#### practice
```sql
SELECT OCCUPATIONS.Name, '(' + SUBSTRING(OCCUPATIONS.Occupation, 1, 1) + ')'
FROM OCCUPATIONS
ORDER BY OCCUPATIONS.Name ASC;

WITH CountOccupations AS (
    SELECT Occupation, COUNT(Name) AS Num   
    FROM OCCUPATIONS
    GROUP BY Occupation
)
SELECT 
(CASE
    WHEN CountOccupations.Occupation = 'Doctor' THEN 'There are a total of ' + CONVERT(varchar(10), CountOccupations.Num) +  ' doctors.'
    WHEN CountOccupations.Occupation = 'Singer' THEN 'There are a total of ' + CONVERT(varchar(10), CountOccupations.Num) +  ' singers.'
    WHEN CountOccupations.Occupation = 'Actor' THEN 'There are a total of ' + CONVERT(varchar(10), CountOccupations.Num) +  ' actors.'
    ELSE 'There are a total of ' + CONVERT(varchar(10), CountOccupations.Num) +  ' professors.'
END)
FROM CountOccupations
ORDER BY CountOccupations.NUm, CountOccupations.Occupation;
```

#### user-defined variables
https://nifannn.github.io/2017/10/21/SQL-Notes-Hackerrank-Occupations/


#### multiple with-as 
```sql
WITH abc AS( select
             FROM ...)
, XYZ AS(select
         From abc ....) /*This one uses "abc" multiple times*/
  Select 
  From XYZ.... 
```

#### substraction of rows from tables
```sql
WITH DISCITY AS (
    SELECT DISTINCT CITY
    FROM STATION
)

SELECT 
  (
    SELECT 
      COUNT (*) as val1 
    FROM 
      STATION
  ) - (
    SELECT 
      COUNT (*) as val2 
    FROM 
      DISCITY
  ) as total_count
```