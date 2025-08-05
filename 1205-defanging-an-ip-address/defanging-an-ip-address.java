class Solution {
    public String defangIPaddr(String address) {

        //return address.replace(".", "[.]");

        StringBuilder defanged = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.') {
                defanged.append("[.]");  
            } else {
                defanged.append(ch);     
            }
        }

        return defanged.toString();
    }
}



        
 