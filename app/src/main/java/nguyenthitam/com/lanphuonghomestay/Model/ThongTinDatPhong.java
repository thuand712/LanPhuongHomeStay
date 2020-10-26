package nguyenthitam.com.lanphuonghomestay.Model;

import java.io.Serializable;

public class ThongTinDatPhong implements Serializable {

    private String tenPhong;

    public ThongTinDatPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
}
