package gui;

public class Main extends Thread {
    public static void main(String[] args) {
        // Thiết lập giao diện Look and Feel (Nimbus)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }

        // Hiển thị form đăng nhập
        LoginForm login = new LoginForm();
        login.setVisible(true);
        Login();
    }

    // Phương thức tạm dừng luồng để tạo hiệu ứng chờ
    public static void Sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Phương thức kiểm tra đăng nhập và chuyển giao diện
    public static void Login() {
        System.out.println("Hello word");
        while (!LoginForm.dangnhap) {
            Sleep(1000);
        }
        if (LoginForm.dangnhap) {
            // Hiển thị màn hình loading
            loading load = new loading();
            load.setVisible(true);
            Sleep(2000);
            load.setVisible(false);
            load.dispose();
            // Mở giao diện chính
            new MainFrame().setVisible(true);
        }
    }
}