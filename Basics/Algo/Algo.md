## Binary Search 
```java
// return the index of x if x is in array a[l...r]
// else return -1 
int BinarySeach(int[] a, int l, int r, int x)
{
    int mid;
    if(l <= r) mid = (l + r)/2;
    else return -1;

    if(a[mid] == x) return mid;
    if(a[mid] < x ) return  BinarySeach(a, mid+1, r, x);
    else return BinarySeach(a, l, mid-1, x);
}
```

## Merge Sort
```java
void sort(int[] a, int l, int r)
{
    if (l < r)
    {
        int mid = (l + r)/2;
        sort(a, l, mid);
        sort(a, l + 1, r);

        merge(a, l, r, mid);

    }
}

void merge(int[] a, int l, int r, int mid)
{
    int n1 = mid-l+1; //length 
    int n2 = r-mid; //length
    int[] L = new int[n1];
    int[] R = new int[n2]; //starts from mid+1

    for(int i = 0; i < n1; i++) L[i] = a[i];
    for(int i = mid+1; i < n2; i++) R[i] = a[i+mid+1];

    int i = 0, j = 0, index = l;
    while(i < n1 && j < n2)
    {
        if(L[i] < R[j]) 
        { 
            a[index] = L[i];
            i++;
        }
        else 
        {
            a[index] = R[j];
            j++;
        }
        index++;
    }

    while (i < n1)
    {
        a[index] = L[i];
        i++;
        index++;
    }

    while (j < n2)
    {
        a[index] = R[j];
        j++;
        index++;
    }
}
```

## Quick Sort
```java
int partition(int[] a, int l, int h)
{
    int pivot = a[h];
    int index = l - 1;

    for(int j = l; j < h; j++)
    {
        if(a[j] < pivot)
        {
            index++;
            swap(a[i], a[j]);
        }
    }

    swap(a[index+1], a[h]);
}

void sort(int[] a, int l, int h)
{
    if(l < h)
    {
        int p = partition(a, l, h);

        sort(a, l, p-1);
        sort(a, p+1, h);
    }
}
```