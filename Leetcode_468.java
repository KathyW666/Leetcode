public class Leetcode_468 {

    public String validIPAddress(String IP) {
        if ("".equals(IP)) {
            return "Neither";
        }
        if (IP.contains(".")) {
            return validIPv4(IP);
        } else if (IP.contains(":")) {
            return validIPv6(IP);
        } else return "Neither";
    }

    public String validIPv4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.' || IP.charAt(0) == '.')
            return "Neither";
        String[] str = IP.split("\\.");
        if (str.length != 4)
            return "Neither";
        int substr;
        char ch;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 3 || "".equals(str[i]))
                return "Neither";
            if (str[i].length() > 1 && str[i].charAt(0) == '0')
                return "Neither";
            for (int j = 0; j < str[i].length(); j++) {
                ch = str[i].charAt(j);
                if ((ch >= '0' && ch <= '9')) continue;
                return "Neither";
            }
            substr = Integer.parseInt(str[i]);
            if (!(substr >= 0 && substr < 256))
                return "Neither";
        }
        return "IPv4";
    }

    public String validIPv6(String IP) {
        IP = IP.toLowerCase();
        if (IP.charAt(IP.length() - 1) == ':' || IP.charAt(0) == ':')
            return "Neither";
        String[] str = IP.split(":");
        if (str.length != 8)
            return "Neither";
        char ch;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 4 || "".equals(str[i]))
                return "Neither";
            for (int j = 0; j < str[i].length(); j++) {
                ch = str[i].charAt(j);
                if ((ch >= 'a' && ch <= 'f') || (ch >= '0' && ch <= '9')) continue;
                return "Neither";
            }
        }
        return "IPv6";
    }

}
