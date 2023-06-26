package data;
public class Certificate {
    private String iD;
    private String certificateId;
    private String certificateName;
    private int certificateRank;
    private String certificateDate;
    public Certificate(){
    }
    public Certificate(String iD, String certificateId, String certificateName,
                       int certificateRank, String certificateDate) {
        this.iD = iD;
        this.certificateId = certificateId;
        this.certificateRank = certificateRank;
        this.certificateName = certificateName;
        this.certificateDate = certificateDate;

    }
    public String toString(){
        return "Id: " + this.iD + ", CertificateId: " + this.certificateId + ", CertificateName: " + this.certificateName;
    }
    public String getiD() {
        return iD;
    }

}
