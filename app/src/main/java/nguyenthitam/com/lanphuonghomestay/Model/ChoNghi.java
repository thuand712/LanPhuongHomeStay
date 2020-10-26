package nguyenthitam.com.lanphuonghomestay.Model;

import java.io.Serializable;

public class ChoNghi implements Serializable {
    private int hinh;

    public ChoNghi(int hinh) {
        this.hinh = hinh;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
