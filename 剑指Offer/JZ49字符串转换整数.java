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
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
