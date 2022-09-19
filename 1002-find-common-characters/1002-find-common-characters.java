class Solution {
    public List<String> commonChars(String[] words) {
    int []common=new int[26];
        Arrays.fill(common,Integer.MAX_VALUE);
        for(int i=0;i<words.length;i++)
        {
            int []cnt=new int[26];
            for(char ch:words[i].toCharArray())
            {
                cnt[ch-'a']++;
            }
            for(int j=0;j<26;j++)
            {
                common[j]=Math.min(common[j],cnt[j]);
            }
        }
    List<String> obj=new ArrayList<>();
        for(int i=0;i<common.length;i++)
        {
            if(common[i]>0)
            {
                for(int k=0;k<common[i];k++)
                    obj.add((char)('a'+i)+"");
            }
        }
        return obj;
    }
}