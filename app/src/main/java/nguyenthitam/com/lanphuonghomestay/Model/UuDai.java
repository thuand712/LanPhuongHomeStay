package nguyenthitam.com.lanphuonghomestay.Model;

import java.io.Serializable;

public class UuDai implements Serializable {
    private int hinh;
    private String tieude,sale;

    public UuDai(int hinh, String tieude, String sale) {
        this.hinh = hinh;
        this.tieude = tieude;
        this.sale = sale;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
