class Solution {
    public String minInteger(String num, int k) 
{
	char[] arr=num.toCharArray();
	int n=arr.length;
	for(int i=0;i<n;++i)
	{
		int pos=i;
		for(int j=i+1;j<n&&j<=i+k;++j)
			if(arr[pos]>arr[j])
				pos=j;
		char temp=arr[pos];
		while(pos!=i)// the swaps are being performed.
		{
			arr[pos]=arr[pos-1];
			--k;
			--pos;
		}
		arr[pos]=temp;
	}
	return new String(arr);
}
}
