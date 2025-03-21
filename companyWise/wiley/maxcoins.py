# n=int(input())
coins=list(map(int,input().split()))

ans=0
def recurse(i,arr,cur):
    global ans
    if(i>=len(arr)):
        ans=max(ans,cur)
        return
    recurse(i+2,arr,cur+arr[i])

    recurse(i+1,arr,cur)
recurse(0,coins,0)
print(ans)
    
    


