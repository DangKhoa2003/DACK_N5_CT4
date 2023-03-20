public class YameStore {
//Đăng ký

    public boolean PhoneNumber(String Sodienthoai)
    {
        if(Sodienthoai.length() >=10 && Sodienthoai.length()<=11)
            return true;
        else
            return false;
    }

    public boolean trimNumber(String Sodienthoai) {
        if(Sodienthoai == "")
            return false;
        else
            return true;
    }

    public boolean specialPhoneNumber(String Sodienthoai) {
        String format = "/^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/";
        if(Sodienthoai.matches(format))
            return true;
        else
            return false;
    }


    //đăng nhập
    public boolean DienThoai(String Sodienthoai)
    {
        if(Sodienthoai == "" || Sodienthoai.length() >=10 && Sodienthoai.length()<=11)
            return true;
        else
            return false;
    }
}