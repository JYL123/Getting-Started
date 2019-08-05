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


### SQL
#### alter table
`ALTER TABLE` lets you add columns to a table in a database.
```sql
ALTER TABLE abc
ADD columnName dataType
```
#### average
```sql
SELECT AVG(someColumn)
FROM tableName
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
