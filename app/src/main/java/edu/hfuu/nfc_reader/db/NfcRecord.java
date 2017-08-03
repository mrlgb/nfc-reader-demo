package edu.hfuu.nfc_reader.db;

/**
 * Created by mr.lgb
 * Date: 2017/8/6.
 */
public class NfcRecord {
    public int id;
    public String nfcId;
    public String recordTime;

    public NfcRecord() {
    }

    public NfcRecord(int id, String nfcId, String recordTime) {
        this.id = id;
        this.nfcId = nfcId;
        this.recordTime = recordTime;
    }
}
