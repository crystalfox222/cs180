public class Case {
    private String caseTitle;
    private String originator;

    public Case(String caseTitle, String originator){
        this.caseTitle = caseTitle;
        this.originator = originator;
    }
    public Case(){

    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public String getOriginator() {
        return originator;
    }
}
