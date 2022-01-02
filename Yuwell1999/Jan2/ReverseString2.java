package Jan2;

// 541
class ReverseString2 {
    public String reverseStr(String s, int K) {
        StringBuffer sb = new StringBuffer();

        int remain = s.length()%(2*K);
        int round=s.length()/(2*K);

        for(int i=0;i<round;i++){
            int offset = i*2*K;
            for(int k=K-1;k>=0;k--){
                sb.append(s.charAt(offset+k));
            }
            for(int k=K;k<2*K;k++){
                sb.append(s.charAt(offset+k));
            }
        }

        if(remain!=0){
            int offset = round*2*K;

            if(remain<K){
                for(int k=s.length()-1;k>=offset;k--){
                    sb.append(s.charAt(k));
                }
            }else{
                for(int k=offset+K-1;k>=offset;k--){
                    sb.append(s.charAt(k));
                }
                for(int k=offset+K;k<s.length();k++){
                    sb.append(s.charAt(k));
                }
            }
        }

        return sb.toString();
    }
}