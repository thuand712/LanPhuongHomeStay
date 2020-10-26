package nguyenthitam.com.lanphuonghomestay.Model;

import java.io.Serializable;

public class ChonPhong implements Serializable {
    private String tenphong;


    public ChonPhong() {
    }

    public ChonPhong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }
}
