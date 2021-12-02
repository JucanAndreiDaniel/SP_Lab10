package ro.uvt.services;

public class StatisticsCommand implements Command{
    @Override
    public void execute() throws Exception {
        RenderContentVisitor stats = new RenderContentVisitor();
        DocumentManager.getInstance().getBook().accept(stats);

        BookStats counter = new BookStats();
        DocumentManager.getInstance().getBook().accept(counter);
        counter.printStatistics();
    }
}
