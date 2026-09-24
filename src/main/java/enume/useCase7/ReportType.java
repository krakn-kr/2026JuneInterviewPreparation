package enume.useCase7;

public enum ReportType implements Printable{
    PDF{
        @Override
        public void print() {
            System.out.println("Printing as PDF");
        }
    },
    EXCEL{
        @Override
        public void print() {
            System.out.println("Printing as EXCEL spreadsheet");
        }
    }
}
