import dao.DAO;
import dao.ServerDAO;
import dao.WorkstationDAO;
import model.Server;
import model.Workstation;
import parser.Parser;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

            final File folder = new File("C:\\Users\\MZheb\\Projects\\JsonFiles");
            readFolder(folder);

    }

    private static void readFolder(final File folder) {
        String folderName = folder.getName();
        System.out.println("Folder: " + folderName);
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                readFolder(fileEntry);
            } else {
                fillDB(folderName, fileEntry);
            }
        }
    }

    private static void fillDB(String folderName, File fileEntry) {
        DAO<?,?> entityDAO;
        List list;
        if (folderName.equalsIgnoreCase("server")) {
            entityDAO = new ServerDAO();
            list = Parser.deserelized(fileEntry.getPath(), Server.class);
        } else {
            entityDAO = new WorkstationDAO();
            list = Parser.deserelized(fileEntry.getPath(), Workstation.class);
        }
        entityDAO.createList(list);
    }

}
