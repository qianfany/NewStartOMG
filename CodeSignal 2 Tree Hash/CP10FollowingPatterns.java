import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CP10FollowingPatterns {
    /**
     *  HashMap
     *  key  =  pattern  value is the designate string
     *  no conflict until the end
     *
     * @param strings
     * @param patterns
     * @return
     */
    public boolean followingPatterns (String[] strings, String[] patterns) {
        if(strings.length<=1){
            return true;
        }

        Map<String,String> mapping = new HashMap<String, String>();
        Map<String, String> patMap = new HashMap<String, String>();
        for(int i = 0; i<strings.length; i++){
            if(mapping.containsKey(strings[i]) && !mapping.get(strings[i]).equals(patterns[i])){
                return false;
            }
            if(patMap.containsKey(patterns[i]) && !patMap.get(patterns[i]).equals(strings[i])){
                return false;
            }

            patMap.put(patterns[i], strings[i]);
            mapping.put(strings[i],patterns[i]);
        }
        return true;
    }

    public static void main (String[] args) {
        CP10FollowingPatterns sol = new CP10FollowingPatterns();
        String[] strings = {"cat", "dog", "dog"};
        String[] patterns = {"a", "b", "a"};
        System.out.println(sol.followingPatterns(strings, patterns));
    }
}
