n=int(input())
arr=[]
for i in range(n):
    arr.append(input().split())

a, b, c = float('inf'), float('inf'), float('inf')
for k in arr:
    if(k[0]=='A'):
        a=min(a, int(k[1]))
    elif(k[0]=='B'):
        b=min(b, int(k[1]))
    else:
        c=min(c, int(k[1]))
print(min(a+b, c))