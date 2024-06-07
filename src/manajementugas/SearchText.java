package manajementugas;

import com.sun.jdi.connect.spi.Connection;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchText extends JTextField {
private Connection connection;
    public SearchText() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        this.connection = connection; // simpan koneksi database yang diterima dari luar
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }
}
