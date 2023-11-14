package DKLH;

public class Lichhen {
    private Integer id;
    private String ngay;
    private String gio;
    private String tenKH;
    private String email;
    private String dienthoai;
    private String ghichu;

    public Lichhen() {
    }

    public Lichhen(Integer id, String ngay, String gio, String tenKH, String email, String dienthoai, String ghichu) {
        this.id = id;
        this.ngay = ngay;
        this.gio = gio;
        this.tenKH = tenKH;
        this.email = email;
        this.dienthoai = dienthoai;
        this.ghichu = ghichu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
    
    

    

    
}

