class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String>result=new ArrayList<>();
        HashSet<Float> set=new HashSet<>();
        for(int i=1;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                float fraction=i*1.0f/j*1.0f;
                if(set.contains(fraction)==false)
                    result.add(i+"/"+j);
                set.add(fraction);
            }
        }
        return result;
    }
}