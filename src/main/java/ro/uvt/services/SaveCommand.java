package ro.uvt.services;

import ro.uvt.models.Paragraph;
import ro.uvt.models.Section;

public class SaveCommand implements Command{
    private final Section section;

    public SaveCommand(Section section) {
        this.section = section;
    }
    
    public void execute() throws Exception {
        this.section.add(new Paragraph("Ceva!"));

        DocumentManager.getInstance().getBook().addContent(this.section);
    }
}
