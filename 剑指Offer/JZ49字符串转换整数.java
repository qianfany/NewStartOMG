public class JZ49字符串转换整数 {
    public int StrToInt(String str) {
        if(str == null || str.length()<=0)
            return 0;
        char[] chars = str.toCharArray();
        long num=0;  // avoid overflow
        boolean minus=false;

        for(int i=0; i<chars.length; i++){
            if(i==0 && chars[i]=='-'){
                minus=true;
            }else if(i==0 && chars[i]=='+'){
                minus=false;
            }else{
                int a=(int) (chars[i]-'0');
                if(a<0 || a>9){
                    return 0;
                }
                num= (minus==false) ? num*10+a : num*10-a;

                if((!minus && num>Integer.MAX_VALUE)//Integer.MAX_VALUE  0x7FFFFFFF
                        ||(minus && num<Integer.MIN_VALUE)){//Integer.MIN_VALUE  0x80000000
                    return 0;
                }
            }
        }
        return (int)num;
    }
}
