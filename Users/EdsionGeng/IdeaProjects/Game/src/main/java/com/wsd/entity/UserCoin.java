package com.wsd.entity;

import java.io.Serializable;

public class UserCoin implements Serializable{
    private int id;
    private  int fUid;
    private  int fJclx;
    private String  cBdsm;
    private  int fBdjf;
    private int  cCategoryNumber;
    private  int  fRelatedId;
    private  String  cRelatedId2;
    private  int fComeFrom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getfUid() {
        return fUid;
    }

    public void setfUid(int fUid) {
        this.fUid = fUid;
    }

    public int getfJclx() {
        return fJclx;
    }

    public void setfJclx(int fJclx) {
        this.fJclx = fJclx;
    }

    public String getcBdsm() {
        return cBdsm;
    }

    public void setcBdsm(String cBdsm) {
        this.cBdsm = cBdsm;
    }

    public int getfBdjf() {
        return fBdjf;
    }

    public void setfBdjf(int fBdjf) {
        this.fBdjf = fBdjf;
    }

    public int getcCategoryNumber() {
        return cCategoryNumber;
    }

    public void setcCategoryNumber(int cCategoryNumber) {
        this.cCategoryNumber = cCategoryNumber;
    }

    public int getfRelatedId() {
        return fRelatedId;
    }

    public void setfRelatedId(int fRelatedId) {
        this.fRelatedId = fRelatedId;
    }

    public String getcRelatedId2() {
        return cRelatedId2;
    }

    public void setcRelatedId2(String cRelatedId2) {
        this.cRelatedId2 = cRelatedId2;
    }

    public int getfComeFrom() {
        return fComeFrom;
    }

    public void setfComeFrom(int fComeFrom) {
        this.fComeFrom = fComeFrom;
    }

    public UserCoin() {
    }

    public UserCoin( int fUid, int fJclx, String cBdsm, int fBdjf, int cCategoryNumber, int fRelatedId, String cRelatedId2, int fComeFrom) {

        this.fUid = fUid;
        this.fJclx = fJclx;
        this.cBdsm = cBdsm;
        this.fBdjf = fBdjf;
        this.cCategoryNumber = cCategoryNumber;
        this.fRelatedId = fRelatedId;
        this.cRelatedId2 = cRelatedId2;
        this.fComeFrom = fComeFrom;
    }

    public UserCoin(int id, int fUid, int fJclx, String cBdsm, int fBdjf, int cCategoryNumber, int fRelatedId, String cRelatedId2, int fComeFrom) {
        this.id = id;
        this.fUid = fUid;
        this.fJclx = fJclx;
        this.cBdsm = cBdsm;
        this.fBdjf = fBdjf;
        this.cCategoryNumber = cCategoryNumber;
        this.fRelatedId = fRelatedId;
        this.cRelatedId2 = cRelatedId2;
        this.fComeFrom = fComeFrom;
    }
}
