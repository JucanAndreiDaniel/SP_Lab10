package ro.uvt;

import ro.uvt.models.*;
import ro.uvt.services.*;

public class Main {
    public static void main(String[] args) throws Exception {
        OpenCommand openCommand = new OpenCommand("Title1");

        Section sectionToSave = new Section("Capitol 14");
        sectionToSave.add(new Paragraph("Acesta este un capitol"));
        SaveCommand saveCommand = new SaveCommand(sectionToSave);

        StatisticsCommand statisticsCommand = new StatisticsCommand();

        openCommand.execute();
        saveCommand.execute();
        statisticsCommand.execute();
    }
}